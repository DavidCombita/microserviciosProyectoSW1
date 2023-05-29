package com.proyectosw1.inventario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectosw1.inventario.models.db.Material;
import com.proyectosw1.inventario.models.db.MaterialTatto;
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
    public void updateUnitsById(int unitis, Long id) {
        materialRepository.updateUnitsById(unitis, id);
    }

    @Override
    public void updateQuantityById(int Quantity, Long id) {
        materialRepository.updateQuantityById(Quantity, id);
    }

    @Override
    public void updateUnitValueById(int UnitValue, Long id) {
        materialRepository.updateUnitValueById(UnitValue, id);
    }

    @Override
    public void updateNameProductById(String NameProduct, Long id) {
        materialRepository.updateNameProductById(NameProduct, id);
    }

    @Override
    public void updateIdCategoryById(Long IdCategory, Long id) {
        materialRepository.updateIdCategoryById(IdCategory, id);
    }

    @Override
    public int sizeMaterials() {
        return (int) insertsRepository.count();
    }
    
    @Override
    public List<MaterialTatto> getAllMaterialsTattoByMaterial(int idTatto) {
        return materialRepository.getAllMaterialsTattoByMaterial(idTatto);
    }

}
