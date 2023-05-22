package com.proyectosw1.inventario.services;

import java.util.List;

import com.proyectosw1.inventario.models.db.Material;

public interface MaterialsService {
    
    public List<Material> getAllMaterial();
   
    public List<Material> getMaterialByCategory(int category);

    public Material saveMaterial(Material newMaterial);

    public void updateUnitsById(int unitis, Long id);

    public void updateQuantityById(int Quantity, Long id);

    public void updateUnitValueById(int UnitValue, Long id);

    public void updateNameProductById(String NameProduct, Long id);

    public void updateIdCategoryById(Long IdCategory, Long id);

    public int sizeMaterials();

}
