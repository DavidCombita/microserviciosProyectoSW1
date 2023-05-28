package com.davidcombita.mstattos.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.davidcombita.mstattos.config.ResourceTattooRowMapper;
import com.davidcombita.mstattos.models.ResourceTatto;

@Repository
public class ResourceTattoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ResourceTatto> findByNumber(int IdTattoo) {
        String sql = "SELECT * FROM ResourceTatto r WHERE r.IdTattoo = " + IdTattoo;
        return jdbcTemplate.query(sql, new ResourceTattooRowMapper());
    }

}
