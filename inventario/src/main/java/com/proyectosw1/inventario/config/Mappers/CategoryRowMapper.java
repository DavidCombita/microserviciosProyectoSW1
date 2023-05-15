package com.proyectosw1.inventario.config.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.proyectosw1.inventario.models.db.CategoryMaterial;

public class CategoryRowMapper implements RowMapper<CategoryMaterial> {

    @Override
    public CategoryMaterial mapRow(ResultSet rs, int rowNum) throws SQLException {
        try{
            CategoryMaterial material = new CategoryMaterial();
            material.setIdCategory(rs.getInt("IdCategory"));
            material.setNameCategory(rs.getString("NameCategory"));
            return material;
        }catch(Exception e){
            throw new UnsupportedOperationException("Unimplemented method 'mapRow'");
        }
    }

    
}
