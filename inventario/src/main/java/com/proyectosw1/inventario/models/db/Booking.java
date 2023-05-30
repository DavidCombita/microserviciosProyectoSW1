package com.proyectosw1.inventario.models.db;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int IdBooking;
    @Getter
    @Setter
    private String NameUser;
    @Getter
    @Setter
    private String EmailUser;
    @Getter
    @Setter
    private int PhoneUser;
    @Getter
    @Setter
    private Date DateBooking;
    @Getter
    @Setter
    private int IdTattoo;
}
