package com.springboilerplate.springboilerplate.message;

import javax.mail.MessagingException;

public interface MailSender {
    void sendMail(String email, String message, String subject) throws MessagingException;
}
