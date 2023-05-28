package com.davidcombita.mstattos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Tattoo")
public class Tattoo {
    @Id
    @Getter
    @Setter
    private int IdTattoo;

    @Getter
    @Setter
    private String Size;
    @Getter
    @Setter
    private String Style;
    @Getter
    @Setter
    private String StateTatto;
    @Getter
    @Setter
    private String Spectrum;
    @Getter
    @Setter
    private String DescriptionTatto;
    @Getter
    @Setter
    private float Price;
}
