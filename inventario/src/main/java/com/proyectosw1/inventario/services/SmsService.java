package com.proyectosw1.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.proyectosw1.inventario.models.db.Booking;
import com.proyectosw1.inventario.repositories.ReservaJPARepository;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class SmsService {

    @Value("${twilio.phoneNumber}")
    private String twilioPhoneNumber;

    @Autowired
    private ReservaJPARepository reservaRepository;

    public Booking saveReserva(Booking booking) {
        return reservaRepository.save(booking);
    }

    public String sendSms(String toPhoneNumber, String toMessage) {
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(toPhoneNumber),
                new com.twilio.type.PhoneNumber("+13159225427"),
                toMessage).create();
        return message.toString();
    }
}
