package com.proyectosw1.inventario.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.proyectosw1.inventario.config.Mappers.MaterialRowMapper;
import com.proyectosw1.inventario.models.db.Material;

public class InventaryRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Material> getAllMaterials() {
        String sql = "SELECT * FROM Material";
        return jdbcTemplate.query(sql, new MaterialRowMapper());
    }

    public List<Material> getAllMaterialsByCategory(int category) {
        String sql = "SELECT * FROM Material WHERE IdCategory ="+category;
        return jdbcTemplate.query(sql, new MaterialRowMapper());
    }
}
