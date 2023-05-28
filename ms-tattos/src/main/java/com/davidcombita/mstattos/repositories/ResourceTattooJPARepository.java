package com.davidcombita.mstattos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davidcombita.mstattos.models.ResourceTatto;

@Repository
public interface ResourceTattooJPARepository extends JpaRepository<ResourceTatto, Long> {
}
