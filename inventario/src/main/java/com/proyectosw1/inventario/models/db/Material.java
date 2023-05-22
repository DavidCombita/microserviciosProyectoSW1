package com.proyectosw1.inventario.models.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Material")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int IdMaterial;

    @Getter @Setter
    private String NameProduct;
    @Getter @Setter
    private int IdCategory;
    @Getter @Setter
    private String NameBrand;
    @Getter @Setter
    private int Quantity;
    @Getter @Setter
    private int Units;
    @Getter @Setter
    private float UnitValue;

}
