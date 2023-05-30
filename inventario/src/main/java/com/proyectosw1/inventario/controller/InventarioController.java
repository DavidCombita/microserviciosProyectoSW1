package com.proyectosw1.inventario.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosw1.inventario.models.db.CategoryMaterial;
import com.proyectosw1.inventario.models.db.Material;
import com.proyectosw1.inventario.models.db.MaterialTatto;
import com.proyectosw1.inventario.services.CategoriesService;
import com.proyectosw1.inventario.services.MaterialsService;
import com.proyectosw1.inventario.services.SmsService;

@RestController
@RequestMapping("/Inventary")
public class InventarioController {

    private static final Logger logger = LoggerFactory.getLogger(InventarioController.class);

    @Autowired
    private MaterialsService materialService;

    @Autowired
    private CategoriesService categoriesService;

    private final SmsService smsInfo;

    @Autowired
    public InventarioController(SmsService sms) {
        this.smsInfo = sms;
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Response OK");
    }

    @GetMapping("/getAllInventary")
    public ResponseEntity<List<Material>> getInfoInventary() {
        try {
            return ResponseEntity.ok(materialService.getAllMaterial());
        } catch (Exception e) {
            logger.error("Error get all inventary", e);
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/getMaterialByTatto")
    public ResponseEntity<List<MaterialTatto>> getMaterialByTatto(int tatto) {
        try {
            return ResponseEntity.ok(materialService.getAllMaterialsTattoByMaterial(tatto));
        } catch (Exception e) {
            logger.error("Error get all inventary", e);
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/getInventaryByCategory")
    public ResponseEntity<List<Material>> getInventaryByCategory(@RequestParam int categorySelected) {
        try {
            return ResponseEntity.ok(materialService.getMaterialByCategory(categorySelected));
        } catch (Exception e) {
            logger.error("Error get all inventary by category", e);
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/getAllCategories")
    public ResponseEntity<List<CategoryMaterial>> getAllCategories() {
        try {
            return ResponseEntity.ok(categoriesService.getAllCategories());
        } catch (Exception e) {
            logger.error("Error get all categories", e);
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/saveCategory")
    public ResponseEntity<CategoryMaterial> saveCategory(String nameCategory) {
        try {
            int newId = categoriesService.sizeCategories() + 1;
            CategoryMaterial newCategory = new CategoryMaterial();
            newCategory.setIdCategory(newId);
            newCategory.setNameCategory(nameCategory);
            CategoryMaterial inseted = categoriesService.saveCategories(newCategory);
            if (inseted != null) {
                logger.info("New category insert: " + inseted.getNameCategory());
                return ResponseEntity.ok(inseted);
            } else {
                logger.warn("Error insert category, get null");
                return ResponseEntity.badRequest().body(inseted);
            }
        } catch (Exception e) {
            logger.error("Error insert category", e);
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PatchMapping("/updateMateria")
    public ResponseEntity<Material> updateMaterial(Material newMaterial) {
        try {
            Material inseted = materialService.updateMaterial(newMaterial);
            if (inseted != null) {
                logger.info("New material insert: " + inseted.getNameProduct());
                return ResponseEntity.ok(inseted);
            } else {
                logger.warn("Error insert material, get null");
                return ResponseEntity.badRequest().body(inseted);
            }
        } catch (Exception e) {
            logger.error("Error insert material", e);
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/saveMaterial")
    public ResponseEntity<Material> saveMaterial(Material newMaterial) {
        try {
            int newId = materialService.getLastInserted();
            logger.info("id material insert: " + newId);
            Material aux = new Material();
            aux.setIdMaterial(newId + 1);
            aux.setIdCategory(newMaterial.getIdCategory());
            aux.setNameProduct(newMaterial.getNameProduct());
            aux.setNameBrand(newMaterial.getNameBrand());
            aux.setQuantity(newMaterial.getQuantity());
            aux.setUnits(newMaterial.getUnits());
            aux.setUnitValue(newMaterial.getUnitValue());
            aux.setAuxUnits(newMaterial.getUnits());
            Material inseted = materialService.saveMaterial(aux);
            if (inseted != null) {
                logger.info("New material insert: " + inseted.getNameProduct());
                return ResponseEntity.ok(inseted);
            } else {
                logger.warn("Error insert material, get null");
                return ResponseEntity.badRequest().body(inseted);
            }
        } catch (Exception e) {
            logger.error("Error insert material", e);
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/updateUnitsById")
    public ResponseEntity<Boolean> updateUnitsById(int unitis, Long id) {
        try {
            Material material = materialService.getMaterialById(id);
            if (unitis > 0) {
                if ((unitis < 3) && (material.getQuantity() == 1)) {
                    logger.warn("Send message warning");
                    smsInfo.sendSms("+573186742164", "Valida por favor la cantidad de: "
                            + material.getNameProduct() + ", porque tienes: " + unitis + " unidades");
                }
                materialService.updateUnitsById(unitis, id);
                return ResponseEntity.ok(true);
            } else {
                if (material.getQuantity() > 1) {
                    materialService.updateUnitsById(material.getUnits(), id);
                    materialService.updateQuantityById(material.getQuantity() - 1, id);
                    return ResponseEntity.ok(true);
                } else {
                    if ((unitis == 0) && (material.getQuantity() == 1)) {
                        materialService.deleteMaterialById(id);
                    }
                    return ResponseEntity.ok(true);
                }
            }
        } catch (Exception e) {
            logger.error("Error update category", e);
            return ResponseEntity.badRequest().body(false);
        }
    }

    @PutMapping("/updateQuantityById")
    public ResponseEntity<Boolean> updateQuantityById(int Quantity, Long id) {
        try {
            if (Quantity > 0) {
                materialService.updateQuantityById(Quantity, id);
                return ResponseEntity.badRequest().body(true);
            } else {
                logger.warn("Update >0 verify info" + Quantity + ", and id: " + id);
                return ResponseEntity.badRequest().body(false);
            }
        } catch (Exception e) {
            logger.error("Error update category", e);
            return ResponseEntity.badRequest().body(false);
        }
    }

    @PutMapping("/updateUnitValueById")
    public ResponseEntity<Boolean> updateUnitValueById(int UnitValue, Long id) {
        try {
            if (UnitValue > 0) {
                materialService.updateUnitValueById(UnitValue, id);
                return ResponseEntity.badRequest().body(true);
            } else {
                logger.warn("Update >0 verify info" + UnitValue + ", and id: " + id);
                return ResponseEntity.badRequest().body(false);
            }
        } catch (Exception e) {
            logger.error("Error update category", e);
            return ResponseEntity.badRequest().body(false);
        }
    }

    @PutMapping("/updateNameProductById")
    public ResponseEntity<Boolean> updateNameProductById(String NameProduct, Long id) {
        try {
            if (!NameProduct.isEmpty() || !NameProduct.isBlank()) {
                materialService.updateNameProductById(NameProduct, id);
                return ResponseEntity.badRequest().body(true);
            } else {
                logger.warn("Update >0 verify info" + NameProduct + ", and id: " + id);
                return ResponseEntity.badRequest().body(false);
            }
        } catch (Exception e) {
            logger.error("Error update category", e);
            return ResponseEntity.badRequest().body(null);
        }
    }

}
