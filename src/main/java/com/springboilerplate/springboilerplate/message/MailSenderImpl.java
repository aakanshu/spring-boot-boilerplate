package com.springboilerplate.springboilerplate.message;

import com.springboilerplate.springboilerplate.dto.MailData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public class MailSenderImpl implements MailSender {

    private JavaMailSender mailSender;
    private AsyncMailer asyncMailer;

    @Autowired
    public MailSenderImpl(JavaMailSender mailSender, AsyncMailer asyncMailer) {
        this.mailSender = mailSender;
        this.asyncMailer = asyncMailer;
    }

    @Override
    public void sendMail(String email, String message, String subject) throws MessagingException {
            MailData mailData = new MailData(email, subject, message, mailSender);
            asyncMailer.sendMail(mailData);
    }
}
