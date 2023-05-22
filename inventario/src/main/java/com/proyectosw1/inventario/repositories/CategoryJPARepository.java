package com.proyectosw1.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectosw1.inventario.models.db.CategoryMaterial;

@Repository
public interface CategoryJPARepository extends JpaRepository<CategoryMaterial, Long> {
}
