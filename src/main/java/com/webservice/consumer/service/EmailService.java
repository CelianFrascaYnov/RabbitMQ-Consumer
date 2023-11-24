package com.webservice.consumer.service;

import com.webservice.consumer.User.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;


@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;


    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@webserviceTP.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    public void sendVerificationEmail(User user) {
        String to = user.getEmail();
        String subject = "Vérification de compte";
        String text = "Pour vérifier votre compte, veuillez cliquer sur le lien suivant : "
                + "http://localhost:8080/verify?token=" + user.getVerificationToken();

        sendEmail(to, subject, text);
    }
}
