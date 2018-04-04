package com.springboilerplate.springboilerplate.message;

import com.springboilerplate.springboilerplate.dto.MailData;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class AsyncMailer {
    @Async
    public void sendMail(MailData mailData) throws MessagingException {
        mailData.sendMessage();
    }
}
