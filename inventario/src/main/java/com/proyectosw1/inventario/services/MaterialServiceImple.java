package com.proyectosw1.inventario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectosw1.inventario.models.db.Material;
import com.proyectosw1.inventario.repositories.InventaryJPARepository;
import com.proyectosw1.inventario.repositories.InventaryRepository;

@Service
public class MaterialServiceImple implements MaterialsService {
    

    @Autowired
    private InventaryRepository materialRepository;

    @Autowired
    private InventaryJPARepository insertsRepository;

    @Override
    public List<Material> getAllMaterial() {
        return materialRepository.getAllMaterials();
    }

    @Override
    public List<Material> getMaterialByCategory(int category) {
        return materialRepository.getAllMaterialsByCategory(category);
    }

    @Override
    public Material saveMaterial(Material newMaterial) {
        return insertsRepository.save(newMaterial);
    }

    @Override
    public int updateUnitsById(int unitis, Long id) {
        return insertsRepository.updateUnitsById(unitis, id);
    }

    @Override
    public int updateQuantityById(int Quantity, Long id) {
        return insertsRepository.updateQuantityById(Quantity, id);
    }

    @Override
    public int updateUnitValueById(int UnitValue, Long id) {
        return insertsRepository.updateUnitValueById(UnitValue, id);
    }

    @Override
    public int updateNameProductById(String NameProduct, Long id) {
        return insertsRepository.updateNameProductById(NameProduct, id);
    }

    @Override
    public int updateIdCategoryById(Long IdCategory, Long id) {
        return insertsRepository.updateIdCategoryById(IdCategory, id);
    }

    @Override
    public int sizeMaterials() {
        return (int) insertsRepository.count();
    }
    
}
