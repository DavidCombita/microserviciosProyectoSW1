package com.proyectosw1.inventario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectosw1.inventario.models.db.CategoryMaterial;
import com.proyectosw1.inventario.repositories.CategoryJPARepository;
import com.proyectosw1.inventario.repositories.CategoryMaterialRepository;

@Service
public class CategoriesServiceImple implements CategoriesService {
    
    @Autowired
    private CategoryMaterialRepository categoryRepository;

    @Autowired
    private CategoryJPARepository insertsRepository;

    @Override
    public List<CategoryMaterial> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    @Override
    public CategoryMaterial saveCategories(CategoryMaterial newCategory) {
        return insertsRepository.save(newCategory);
    }

    @Override
    public int sizeCategories() {
        return (int) insertsRepository.count();
    }

    @Override
    public int updateCategories(String newName, Long id) {
        return insertsRepository.updateNameById(newName, id);
    }

}
