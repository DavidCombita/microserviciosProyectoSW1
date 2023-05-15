package com.proyectosw1.inventario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectosw1.inventario.models.db.Material;
import com.proyectosw1.inventario.repositories.InventaryRepository;

@Service
public class MaterialServiceImple implements MaterialsService {

    @Autowired
    private InventaryRepository materialRepository;

    @Override
    public List<Material> getAllMaterial() {
        return materialRepository.getAllMaterials();
    }
    
}
