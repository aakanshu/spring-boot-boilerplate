package com.springboilerplate.springboilerplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan(basePackages = {"portal.message"})
public class MessageConfig {

    @Bean
    public JavaMailSender javaMailSender(){
        return new JavaMailSenderImpl();
    }
}
