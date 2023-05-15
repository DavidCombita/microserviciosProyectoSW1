package com.proyectosw1.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosw1.inventario.models.db.CategoryMaterial;
import com.proyectosw1.inventario.models.db.Material;
import com.proyectosw1.inventario.services.MaterialsService;

@RestController
@RequestMapping("/Inventary")
public class InventarioController {

    @Autowired
    private MaterialsService materialService;
    
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

    @GetMapping("/getAllCategories")
    public ResponseEntity<List<CategoryMaterial>> getAllCategories() {
        return null;
    }
}
