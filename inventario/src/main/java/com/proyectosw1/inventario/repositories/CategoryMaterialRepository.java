package com.proyectosw1.inventario.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.proyectosw1.inventario.config.Mappers.CategoryRowMapper;
import com.proyectosw1.inventario.models.db.CategoryMaterial;

import jakarta.transaction.Transactional;

@Repository
public class CategoryMaterialRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CategoryMaterial> getAllCategories() {
        String sql = "SELECT * FROM CategoryMaterial";
        return jdbcTemplate.query(sql, new CategoryRowMapper());
    }

    @Transactional
    public void updateNameById(String newName, Long id) {
        String sql = "UPDATE CategoryMaterial t SET t.NameCategory ='" + newName + "' WHERE t.IdCategory = " + id;
        jdbcTemplate.update(sql);
    }
}
