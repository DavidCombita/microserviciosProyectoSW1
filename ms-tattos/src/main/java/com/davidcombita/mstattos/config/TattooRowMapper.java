package com.davidcombita.mstattos.config;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.davidcombita.mstattos.models.Tattoo;

public class TattooRowMapper implements RowMapper<Tattoo> {

    @Override
    public Tattoo mapRow(ResultSet rs, int rowNum) throws SQLException {
        try {
            Tattoo tattoo = new Tattoo();
            tattoo.setIdTattoo(rs.getInt("IdTattoo"));
            tattoo.setSize(rs.getString("Size"));
            tattoo.setStyle(rs.getString("Style"));
            tattoo.setStateTatto(rs.getString("StateTatto"));
            tattoo.setSpectrum(rs.getString("Spectrum"));
            tattoo.setDescriptionTatto(rs.getString("DescriptionTatto"));
            tattoo.setPrice(rs.getFloat("Price"));
            return tattoo;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Unimplemented method 'mapRow'");
        }
    }

}
