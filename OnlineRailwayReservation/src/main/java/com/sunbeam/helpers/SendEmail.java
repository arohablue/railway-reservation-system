package com.sunbeam.helpers;
// File Name SendEmail.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class SendEmail {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendOTP(String toEmail, String otp) {
        SimpleMailMessage email = new SimpleMailMessage();

        email.setTo(toEmail);
        email.setFrom("marstech.alerts@gmail.com");
        email.setSubject("OTP");
        email.setText(otp);

        try {
            javaMailSender.send(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}