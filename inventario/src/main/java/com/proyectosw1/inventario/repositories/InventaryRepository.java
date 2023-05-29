package com.proyectosw1.inventario.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.proyectosw1.inventario.config.Mappers.MaterialRowMapper;
import com.proyectosw1.inventario.config.Mappers.MaterialTattoRowMapper;
import com.proyectosw1.inventario.models.db.Material;
import com.proyectosw1.inventario.models.db.MaterialTatto;

import jakarta.transaction.Transactional;

@Repository
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

    public List<MaterialTatto> getAllMaterialsTattoByMaterial(int idTatto) {
        String sql = "SELECT m.IdMaterial, m.idCategory, m.nameProduct, m.unitValue " +
                "FROM Material m JOIN TattooMaterial t on m.IdMaterial = t.IdMaterial " +
                "WHERE t.IdTattoo = " + idTatto;
        return jdbcTemplate.query(sql, new MaterialTattoRowMapper());
    }

    @Transactional
    public void updateUnitsById(int unitis, Long id) {
        String sql = "UPDATE Material SET Units =" + unitis + " WHERE IdMaterial = " + id;
        jdbcTemplate.update(sql);
    }

    @Transactional
    public void updateQuantityById(int Quantity, Long id) {
        String sql = "UPDATE Material SET Quantity =" + Quantity + " WHERE IdMaterial = " + id;
        jdbcTemplate.update(sql);
    }

    @Transactional
    public void updateUnitValueById(int UnitValue, Long id) {
        String sql = "UPDATE Material SET UnitValue = " + UnitValue + " WHERE t.IdMaterial = " + id;
        jdbcTemplate.update(sql);
    }

    @Transactional
    public void updateNameProductById(String NameProduct, Long id) {
        String sql = "UPDATE Material SET NameProduct = '" + NameProduct + "' WHERE IdMaterial = " + id;
        jdbcTemplate.update(sql);
    }

    @Transactional
    public void updateIdCategoryById(Long IdCategory, Long id) {
        String sql = "UPDATE Material SET IdCategory = '" + IdCategory + "' WHERE IdMaterial = " + id;
        jdbcTemplate.update(sql);
    }

}
