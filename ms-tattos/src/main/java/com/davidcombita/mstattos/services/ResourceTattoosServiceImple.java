package com.davidcombita.mstattos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davidcombita.mstattos.models.ResourceTatto;
import com.davidcombita.mstattos.repositories.ResourceTattoRepository;
import com.davidcombita.mstattos.repositories.ResourceTattooJPARepository;

@Service
public class ResourceTattoosServiceImple implements ResourceTattooService {

    @Autowired
    ResourceTattooJPARepository resourceTattoRepository;

    @Autowired
    ResourceTattoRepository resourceTatto;

    @Override
    public List<ResourceTatto> getResourceById(int idTatto) {
        return resourceTatto.findByNumber(idTatto);
    }

    public ResourceTatto saveResourceTattoo(ResourceTatto newCategory) {
        return resourceTattoRepository.save(newCategory);
    }

    public long sizeResourceTatto() {
        return resourceTattoRepository.count();
    }

    public void updateResourceTatto(String ResourceTatto, Long idResourceTatto) {

    }
}
