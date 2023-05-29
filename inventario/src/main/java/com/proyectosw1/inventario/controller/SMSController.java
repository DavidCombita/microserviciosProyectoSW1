package com.proyectosw1.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosw1.inventario.services.SmsService;
import com.proyectosw1.inventario.utils.CalculatorTattoHelper;

@RestController
@RequestMapping("/SMS")
public class SMSController {

    private final SmsService smsInfo;

    @Autowired
    public SMSController(SmsService sms) {
        this.smsInfo = sms;
    }

    @PostMapping("/send-sms")
    public void sendSms(@RequestParam("to") String toPhone, @RequestParam("fecha") String date,
            @RequestParam("style") String style, @RequestParam("size") String size) {

        double valueAproxhelper = CalculatorTattoHelper.getCalculatorTatto(style, size);
        smsInfo.sendSms(toPhone, "Reservado su tatuaje para el: " + date);
        // Mensaje para notificar al tatuador
        smsInfo.sendSms("+573186742164", "Hiciste la reserva del tatuaje para el: " + date +
                ", valor aprox:" + valueAproxhelper);
    }
}
