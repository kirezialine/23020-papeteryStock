package com.papeterystock.papeteryStock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

    @Service
    public class MailService {

        @Autowired
        @Qualifier("gmail")
        private JavaMailSender mailSender;

        public void sendMail(String toAddresses) {
            MimeMessagePreparator preparator = (javax.mail.internet.MimeMessage mimeMessage) -> {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(toAddresses.split("[,;]"));
                message.setFrom("kirezialine26@gmail.com", "<aline>");
                message.setSubject("Email Sent");
                message.setText("You have sent an email", true);
            };
            mailSender.send(preparator);
        }
    }

