package com.proyectosw1.inventario.models.db;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CategoryMaterial")
public class CategoryMaterial {
    @Id
    @Getter @Setter
    private int IdCategory;

    @Getter @Setter
    private String NameCategory;
}
