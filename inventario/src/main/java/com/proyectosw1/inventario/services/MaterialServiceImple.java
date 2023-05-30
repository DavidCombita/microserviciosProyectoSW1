package com.proyectosw1.inventario.services;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Material getMaterialById(Long id) {
        return materialRepository.getMaterialById(id);
    }

    @Override
    public void deleteMaterialById(Long id) {
        insertsRepository.deleteById(id);
    }

    @Override
    public int getLastInserted() {
        return materialRepository.getIdLastInserted();
    }

    @Override
    public Material updateMaterial(Material aux) {
        Optional<Material> objetoExistente = insertsRepository.findById(Long.valueOf(aux.getIdMaterial()));
        try {
            if (objetoExistente != null) {
                objetoExistente.get().setNameProduct(aux.getNameProduct());
                objetoExistente.get().setNameBrand(aux.getNameBrand());
                objetoExistente.get().setIdCategory(aux.getIdCategory());
                objetoExistente.get().setQuantity(aux.getQuantity());
                objetoExistente.get().setUnits(aux.getUnits());
                objetoExistente.get().setUnitValue(aux.getUnitValue());
                objetoExistente.get().setAuxUnits(aux.getUnits());
                insertsRepository.flush();
            }
            return aux;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

}
