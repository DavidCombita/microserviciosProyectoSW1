package com.proyectosw1.inventario.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosw1.inventario.models.db.Booking;
import com.proyectosw1.inventario.services.SmsService;
import com.proyectosw1.inventario.utils.CalculatorTattoHelper;

@RestController
@RequestMapping("/SMS")
public class SMSController {

    private static final Logger logger = LoggerFactory.getLogger(InventarioController.class);

    private final SmsService smsInfo;

    @Autowired
    public SMSController(SmsService sms) {
        this.smsInfo = sms;
    }

    @PostMapping("/saveReserva")
    public ResponseEntity<Boolean> sendSms(@RequestParam("to") Long toPhone, @RequestParam("fecha") String date,
            @RequestParam("style") String style, @RequestParam("size") String size, @RequestParam("name") String name,
            @RequestParam("email") String email, @RequestParam("idTatto") int idTatto) {
        try {
            Booking aux = new Booking();
            String[] fechaaux = date.split("-");
            aux.setNameUser(name);
            aux.setEmailUser(email);
            aux.setPhoneUser(toPhone.intValue());
            aux.setDateBooking(new Date(Integer.parseInt(fechaaux[0]), Integer.parseInt(fechaaux[1]),
                    Integer.parseInt(fechaaux[2])));
            aux.setIdTattoo(idTatto);
            smsInfo.saveReserva(aux);
            double valueAproxhelper = CalculatorTattoHelper.getCalculatorTatto(size, style);
            // smsInfo.sendSms("+57" + toPhone, "Reservado su tatuaje para el: " + date);
            // Mensaje para notificar al tatuador
            smsInfo.sendSms("+573186742164", "Hiciste la reserva del tatuaje para el: " +
                    date + ", valor aprox: $" + valueAproxhelper + ", número del cliente: " + toPhone);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            logger.error("Error en reserva", e);
            return ResponseEntity.badRequest().body(false);
        }

    }
}
