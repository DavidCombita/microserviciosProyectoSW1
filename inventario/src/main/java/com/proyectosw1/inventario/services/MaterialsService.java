package com.proyectosw1.inventario.services;

import java.util.List;

import com.proyectosw1.inventario.models.db.Material;

public interface MaterialsService {
    
    public List<Material> getAllMaterial();
   
    public List<Material> getMaterialByCategory(int category);

    public Material saveMaterial(Material newMaterial);

    public int updateUnitsById(int unitis, Long id);

    public int updateQuantityById(int Quantity, Long id);

    public int updateUnitValueById(int UnitValue, Long id);

    public int updateNameProductById(String NameProduct, Long id);

    public int updateIdCategoryById(Long IdCategory, Long id);

    public int sizeMaterials();

}
