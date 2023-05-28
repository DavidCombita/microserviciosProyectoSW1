package com.davidcombita.mstattos.config;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.davidcombita.mstattos.models.ResourceTatto;

public class ResourceTattooRowMapper implements RowMapper<ResourceTatto> {

    @Override
    public ResourceTatto mapRow(ResultSet rs, int rowNum) throws SQLException {
        try {
            ResourceTatto tattoo = new ResourceTatto();
            tattoo.setIdResource(rs.getInt("IdResource"));
            tattoo.setDescResource(rs.getString("DescResource"));
            tattoo.setUrlImage(rs.getString("UrlImage"));
            tattoo.setTypeResource(rs.getString("TypeResource"));
            tattoo.setIdTattoo(rs.getInt("IdTattoo"));
            return tattoo;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Unimplemented method 'mapRow'");
        }
    }

}
