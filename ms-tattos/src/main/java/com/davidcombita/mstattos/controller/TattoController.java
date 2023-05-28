package com.davidcombita.mstattos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Tatto")
public class TattoController {

    private static final Logger logger = LoggerFactory.getLogger(TattoController.class);

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Response OK");
    }

}
