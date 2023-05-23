package com.proyectosw1.inventario.config.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.proyectosw1.inventario.models.db.Material;

public class MaterialRowMapper implements RowMapper<Material> {

    @Override
    public Material mapRow(ResultSet rs, int rowNum) throws SQLException {
        try{
            Material material = new Material();
            material.setIdMaterial(rs.getInt("IdMaterial"));
            material.setNameProduct(rs.getString("NameProduct"));
            material.setIdCategory(rs.getInt("IdCategory"));
            material.setNameBrand(rs.getString("NameBrand"));
            material.setQuantity(rs.getInt("Quantity"));
            material.setUnits(rs.getInt("Units"));
            material.setUnitValue(rs.getFloat("UnitValue"));
            return material;
        }catch(Exception e){
            throw new UnsupportedOperationException("Unimplemented method 'mapRow'");
        }
    }

    
}
