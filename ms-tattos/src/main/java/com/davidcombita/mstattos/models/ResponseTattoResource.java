package com.davidcombita.mstattos.models;

import java.util.List;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

public class ResponseTattoResource {
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

    @Getter
    @Setter
    private List<ResourceTatto> resource;
}
