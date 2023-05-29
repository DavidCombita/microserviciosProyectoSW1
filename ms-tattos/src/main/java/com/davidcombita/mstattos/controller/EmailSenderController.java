package com.davidcombita.mstattos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davidcombita.mstattos.services.EmailService;

@RestController
@RequestMapping("/Reserva")
public class EmailSenderController {
    @Autowired
    private EmailService emailService;

    private static final Logger logger = LoggerFactory.getLogger(TattoController.class);

    @PostMapping("/sendEmail")
    public void sendEmail(@RequestBody String email) {

        String to = email;
        String subject = "Registro exitoso";
        String body = "28-05-2023";
        emailService.sendEmail(to, subject, body);
    }
}
