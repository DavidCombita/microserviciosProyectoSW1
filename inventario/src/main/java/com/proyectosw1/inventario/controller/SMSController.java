package com.proyectosw1.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosw1.inventario.services.SmsService;

@RestController
@RequestMapping("/SMS")
public class SMSController {

    private final SmsService smsInfo;

    @Autowired
    public SMSController(SmsService sms) {
        this.smsInfo = sms;
    }

    @PostMapping("/send-sms")
    public void sendSms(@RequestParam("to") String toPhone) {
        smsInfo.sendSms(toPhone, "Reservado su tatuaje para el: 29/05/2023");
    }
}
