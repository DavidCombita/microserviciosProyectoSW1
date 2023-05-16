package com.proyectosw1.inventario.services;

import java.util.List;

import com.proyectosw1.inventario.models.db.CategoryMaterial;

public interface CategoriesService {
    
    public List<CategoryMaterial> getAllCategories();

    public CategoryMaterial saveCategories(CategoryMaterial newCategory);

    public int sizeCategories();
}
