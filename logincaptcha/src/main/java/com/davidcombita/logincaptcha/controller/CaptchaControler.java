package com.davidcombita.logincaptcha.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Captcha01")
public class CaptchaControler {

    @GetMapping("/verifyCap")
    public ResponseEntity<Boolean> verify(@RequestBody String token) {
        return ResponseEntity.ok(true);
    }

}
