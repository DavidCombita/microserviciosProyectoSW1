package com.proyectosw1.inventario.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;

@Service
public class SmsService {

    @Value("${twilio.phoneNumber}")
    private String twilioPhoneNumber;

    public String sendSms(String toPhoneNumber, String toMessage) {
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(toPhoneNumber),
                new com.twilio.type.PhoneNumber("+13159225427"),
                toMessage).create();
        return message.toString();
    }
}
