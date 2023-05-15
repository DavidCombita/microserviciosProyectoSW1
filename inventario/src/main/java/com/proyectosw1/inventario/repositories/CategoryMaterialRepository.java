package com.proyectosw1.inventario.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.proyectosw1.inventario.config.Mappers.CategoryRowMapper;
import com.proyectosw1.inventario.models.db.CategoryMaterial;

public class CategoryMaterialRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CategoryMaterial> getAllCategories() {
        String sql = "SELECT * FROM CategoryMaterial";
        return jdbcTemplate.query(sql, new CategoryRowMapper());
    }
}
