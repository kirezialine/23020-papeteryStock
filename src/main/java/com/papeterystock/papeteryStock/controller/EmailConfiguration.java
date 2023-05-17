package com.papeterystock.papeteryStock.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.mail.internet.MimeBodyPart;

@Configuration
    public class EmailConfiguration {

        @Bean
        public MimeBodyPart mimeBodyPart() {
            return new MimeBodyPart();
        }
    }

