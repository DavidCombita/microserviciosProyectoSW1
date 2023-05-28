package com.davidcombita.mstattos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davidcombita.mstattos.models.Tattoo;;

@Repository
public interface TattooJPARepository extends JpaRepository<Tattoo, Long> {
}
