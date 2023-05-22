package com.proyectosw1.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyectosw1.inventario.models.db.CategoryMaterial;

@Repository
public interface CategoryJPARepository extends JpaRepository<CategoryMaterial, Long> {
    public CategoryMaterial save(CategoryMaterial category);

    @Modifying
    @Query("UPDATE CategoryMaterial t SET t.NameCategory = ?1 WHERE t.id = ?2")
    int updateNameById(String newName, Long id);
}
