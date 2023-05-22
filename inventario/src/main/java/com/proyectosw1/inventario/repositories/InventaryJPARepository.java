package com.proyectosw1.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyectosw1.inventario.models.db.Material;

@Repository
public interface InventaryJPARepository extends JpaRepository<Material, Long> {

    public Material save(Material category);

    @Modifying
    @Query("UPDATE Material t SET t.Units = ?1 WHERE t.id = ?2")
    int updateUnitsById(int unitis, Long id);

    @Modifying
    @Query("UPDATE Material t SET t.Quantity = ?1 WHERE t.id = ?2")
    int updateQuantityById(int Quantity, Long id);

    @Modifying
    @Query("UPDATE Material t SET t.UnitValue = ?1 WHERE t.id = ?2")
    int updateUnitValueById(int UnitValue, Long id);

    @Modifying
    @Query("UPDATE Material t SET t.NameProduct = ?1 WHERE t.id = ?2")
    int updateNameProductById(String NameProduct, Long id);

    @Modifying
    @Query("UPDATE Material t SET t.IdCategory = ?1 WHERE t.id = ?2")
    int updateIdCategoryById(Long IdCategory, Long id);

}
