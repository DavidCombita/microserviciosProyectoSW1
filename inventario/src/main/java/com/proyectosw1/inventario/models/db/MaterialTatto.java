package com.proyectosw1.inventario.models.db;

import lombok.Getter;
import lombok.Setter;

public class MaterialTatto {

    @Getter
    @Setter
    private int IdMaterial;
    @Getter
    @Setter
    private String NameProduct;
    @Getter
    @Setter
    private int IdCategory;
    @Getter
    @Setter
    private float UnitValue;
}
