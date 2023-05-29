package com.proyectosw1.inventario.config.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.proyectosw1.inventario.models.db.MaterialTatto;

public class MaterialTattoRowMapper implements RowMapper<MaterialTatto> {

    @Override
    public MaterialTatto mapRow(ResultSet rs, int rowNum) throws SQLException {
        try {
            MaterialTatto material = new MaterialTatto();
            material.setIdMaterial(rs.getInt("IdMaterial"));
            material.setNameProduct(rs.getString("NameProduct"));
            material.setIdCategory(rs.getInt("IdCategory"));
            material.setUnitValue(rs.getFloat("UnitValue"));
            return material;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Unimplemented method 'mapRow'");
        }
    }

}
