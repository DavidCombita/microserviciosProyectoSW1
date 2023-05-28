package com.davidcombita.mstattos.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davidcombita.mstattos.models.ResourceTatto;
import com.davidcombita.mstattos.models.ResponseTattoResource;
import com.davidcombita.mstattos.models.Tattoo;
import com.davidcombita.mstattos.services.ResourceTattooService;
import com.davidcombita.mstattos.services.TattooService;

@RestController
@RequestMapping("/Tatto")
public class TattoController {

    private static final Logger logger = LoggerFactory.getLogger(TattoController.class);

    @Autowired
    private TattooService tattoo;

    @Autowired
    private ResourceTattooService resourceService;

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Response OK");
    }

    @GetMapping("/getHomeTattos")
    public ResponseEntity<List<ResponseTattoResource>> getHomeTattos() {
        try {
            List<Tattoo> tattos = tattoo.getThreePortada();
            List<ResponseTattoResource> response = new ArrayList<ResponseTattoResource>();
            for (Tattoo tatto : tattos) {
                List<ResourceTatto> resource = resourceService.getResourceById(tatto.getIdTattoo());
                ResponseTattoResource resp = new ResponseTattoResource();
                resp.setResource(resource);
                resp.setIdTattoo(tatto.getIdTattoo());
                resp.setSize(tatto.getSize());
                resp.setStyle(tatto.getStyle());
                resp.setStateTatto(tatto.getStateTatto());
                resp.setSpectrum(tatto.getSpectrum());
                resp.setDescriptionTatto(tatto.getDescriptionTatto());
                resp.setPrice(tatto.getPrice());
                response.add(resp);
            }
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error get portada", e);
            return ResponseEntity.badRequest().body(null);
        }
    }

}
