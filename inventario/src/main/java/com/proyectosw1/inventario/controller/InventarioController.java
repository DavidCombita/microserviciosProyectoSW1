package com.proyectosw1.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
            return ResponseEntity.badRequest().body(null);
        } 
    }

    @GetMapping("/getInventaryByCategory")
    public ResponseEntity<List<Material>> getInventaryByCategory(@RequestParam int categorySelected) {
        try {
            return ResponseEntity.ok(materialService.getMaterialByCategory(categorySelected));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        } 
    }

    @GetMapping("/getAllCategories")
    public ResponseEntity<List<CategoryMaterial>> getAllCategories() {
        try {
            return ResponseEntity.ok(categoriesService.getAllCategories());
        } catch (Exception e) {
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
            if(inseted!= null){
                return ResponseEntity.ok(inseted);
            }else{
                return ResponseEntity.badRequest().body(inseted);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        } 
    }
}
