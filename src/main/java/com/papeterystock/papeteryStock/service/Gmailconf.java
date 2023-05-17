package com.papeterystock.papeteryStock.service;

import jakarta.persistence.Entity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


import java.util.Properties;
@Configuration
public class Gmailconf {
        @Bean("gmail")
        public JavaMailSender gmailMailSender() {
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost("smtp.gmail.com");
            mailSender.setPort(8081);

            mailSender.setUsername("kirezialine26@gmail.com");
            mailSender.setPassword("aline123");

            Properties props = mailSender.getJavaMailProperties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.debug", "false");

            return mailSender;
        }
    }

