package com.davidcombita.mstattos.services;

import java.util.List;

import com.davidcombita.mstattos.models.Tattoo;;

public interface TattooService {

    public List<Tattoo> getThreePortada();

    public Tattoo saveTattoo(Tattoo newCategory);

    public long sizeTattoos();

    public void updateTattoo(String nameTatto, Long idTattoo);
}
