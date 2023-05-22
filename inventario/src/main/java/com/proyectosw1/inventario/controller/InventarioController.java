package com.proyectosw1.inventario.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosw1.inventario.models.db.CategoryMaterial;
import com.proyectosw1.inventario.models.db.Material;
import com.proyectosw1.inventario.services.CategoriesService;
import com.proyectosw1.inventario.services.MaterialsService;

@RestController
@RequestMapping("/Inventary")
public class InventarioController {

    private static final Logger logger = LoggerFactory.getLogger(InventarioController.class);

    @Autowired
    private MaterialsService materialService;

    @Autowired
    private CategoriesService categoriesService;

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
            int newId = categoriesService.sizeCategories();
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

    @PostMapping("/saveMaterial")
    public ResponseEntity<Material> saveMaterial(Material newMaterial) {
        try {
            int newId = materialService.sizeMaterials();
            newMaterial.setIdMaterial(newId);
            Material inseted = materialService.saveMaterial(newMaterial);
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
    public ResponseEntity<Integer> updateUnitsById(int unitis, Long id) {
        try {
            if (unitis > 0) {
                int inseted = materialService.updateUnitsById(unitis, id);
                if (inseted > 0) {
                    logger.info("Num files update: " + inseted);
                    return ResponseEntity.ok(inseted);
                } else {
                    logger.warn("Update 0 verify info" + unitis + ", and id: " + id);
                    return ResponseEntity.badRequest().body(inseted);
                }
            } else {
                logger.warn("Update >0 verify info" + unitis + ", and id: " + id);
                return ResponseEntity.badRequest().body(unitis);
            }
        } catch (Exception e) {
            logger.error("Error update category", e);
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/updateQuantityById")
    public ResponseEntity<Integer> updateQuantityById(int Quantity, Long id) {
        try {
            if (Quantity > 0) {
                int inseted = materialService.updateQuantityById(Quantity, id);
                if (inseted > 0) {
                    logger.info("Num files update: " + inseted);
                    return ResponseEntity.ok(inseted);
                } else {
                    logger.warn("Update 0 verify info" + Quantity + ", and id: " + id);
                    return ResponseEntity.badRequest().body(inseted);
                }
            } else {
                logger.warn("Update >0 verify info" + Quantity + ", and id: " + id);
                return ResponseEntity.badRequest().body(Quantity);
            }
        } catch (Exception e) {
            logger.error("Error update category", e);
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/updateUnitValueById")
    public ResponseEntity<Integer> updateUnitValueById(int UnitValue, Long id) {
        try {
            if (UnitValue > 0) {
                int inseted = materialService.updateUnitValueById(UnitValue, id);
                if (inseted > 0) {
                    logger.info("Num files update: " + inseted);
                    return ResponseEntity.ok(inseted);
                } else {
                    logger.warn("Update 0 verify info" + UnitValue + ", and id: " + id);
                    return ResponseEntity.badRequest().body(inseted);
                }
            } else {
                logger.warn("Update >0 verify info" + UnitValue + ", and id: " + id);
                return ResponseEntity.badRequest().body(UnitValue);
            }
        } catch (Exception e) {
            logger.error("Error update category", e);
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/updateNameProductById")
    public ResponseEntity<Integer> updateNameProductById(String NameProduct, Long id) {
        try {
            if (!NameProduct.isEmpty() || !NameProduct.isBlank()) {
                int inseted = materialService.updateNameProductById(NameProduct, id);
                if (inseted > 0) {
                    logger.info("Num files update: " + inseted);
                    return ResponseEntity.ok(inseted);
                } else {
                    logger.warn("Update 0 verify info" + NameProduct + ", and id: " + id);
                    return ResponseEntity.badRequest().body(inseted);
                }
            } else {
                logger.warn("Update >0 verify info" + NameProduct + ", and id: " + id);
                return ResponseEntity.badRequest().body(0);
            }
        } catch (Exception e) {
            logger.error("Error update category", e);
            return ResponseEntity.badRequest().body(null);
        }
    }

}
