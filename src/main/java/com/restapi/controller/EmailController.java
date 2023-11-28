package com.restapi.controller;

import com.restapi.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public String sendEmail(@RequestBody String email) {
        String to = email;
        String subject = "Car Booking Confirmation";
        String body = "Your booing has been confirmed";

        emailService.sendSimpleEmail(to, subject, body);

        return "Email sent successfully!";
    }
}
