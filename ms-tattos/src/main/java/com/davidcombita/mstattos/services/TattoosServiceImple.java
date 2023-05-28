package com.davidcombita.mstattos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davidcombita.mstattos.models.Tattoo;
import com.davidcombita.mstattos.repositories.TattooJPARepository;

@Service
public class TattoosServiceImple implements TattooService {

    @Autowired
    private TattooJPARepository tattoRepository;

    @Override
    public List<Tattoo> getThreePortada() {
        return tattoRepository.findAll();
    }

    @Override
    public Tattoo saveTattoo(Tattoo newCategory) {
        return tattoRepository.save(newCategory);
    }

    @Override
    public long sizeTattoos() {
        return tattoRepository.count();
    }

    @Override
    public void updateTattoo(String nameTatto, Long idTattoo) {
    }
}
