package com.example.controller;

import com.example.domain.User;
import com.example.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    private NotificationService notificationService;

    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    public RegistrationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RequestMapping("/signup")
    public String signup() {
        return "Please sign up for our service";
    }

    @RequestMapping("/signup-success")
    public String signupSuccess() {

        User registerUser = new User("Alexander", "Konovalov", "aleksaander@ya.ru");

        try {
            notificationService.sendNotification(registerUser);
        } catch (MailException e) {
            logger.error("Email sending error: " + e.getMessage());
            e.printStackTrace();
        }

        return "Thank you for register. Check out your email for notification message.";
    }
}
