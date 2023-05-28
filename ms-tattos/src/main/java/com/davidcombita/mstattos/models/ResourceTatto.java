package com.davidcombita.mstattos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ResourceTatto")
public class ResourceTatto {

    @Id
    @Getter
    @Setter
    private int IdResource;

    @Getter
    @Setter
    private String DescResource;
    @Getter
    @Setter
    private String UrlImage;
    @Getter
    @Setter
    private String TypeResource;
    @Getter
    @Setter
    private int IdTattoo;

}
