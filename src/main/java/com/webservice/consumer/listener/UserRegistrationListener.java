package com.webservice.consumer.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webservice.consumer.User.User;
import com.webservice.consumer.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserRegistrationListener {

    @Autowired
    private EmailService emailService;

    @Autowired
    private ObjectMapper objectMapper;


    @RabbitListener(queues = "rabbitmq")
    public void receiveMessage(String message) {
        emailService.sendVerificationEmail(Objects.requireNonNull(extractUserFromMessage(message)));
    }

    private User extractUserFromMessage(String message) {
        try {
            return objectMapper.readValue(message, User.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}