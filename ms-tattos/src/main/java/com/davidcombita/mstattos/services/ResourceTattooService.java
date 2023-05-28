package com.davidcombita.mstattos.services;

import java.util.List;

import com.davidcombita.mstattos.models.ResourceTatto;

public interface ResourceTattooService {

    public List<ResourceTatto> getResourceById(int id);

    public ResourceTatto saveResourceTattoo(ResourceTatto newCategory);

    public long sizeResourceTatto();

    public void updateResourceTatto(String ResourceTatto, Long idResourceTatto);
}
