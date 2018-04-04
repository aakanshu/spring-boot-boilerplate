package com.springboilerplate.springboilerplate.dto;

import org.springframework.core.io.InputStreamResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


public class MailData {
    private static final String from = "noreply@wrisx.com";
    private String to;
    private String subject;
    private String text;
    private String fileName;
    private InputStreamResource inputStreamResource;
    private JavaMailSender mailSender;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public InputStreamResource getInputStreamResource() {
        return inputStreamResource;
    }

    public void setInputStreamResource(InputStreamResource inputStreamResource) {
        this.inputStreamResource = inputStreamResource;
    }

    public MailData(String to, String subject, String text, JavaMailSender mailSender) {
        this.to = to;
        this.subject = subject;
        this.text = text;
        this.mailSender = mailSender;
    }

    public MailData(String to, String subject, String text, JavaMailSender mailSender,
                    String fileName, InputStreamResource inputStreamResource) {
        this.to = to;
        this.subject = subject;
        this.text = text;
        this.mailSender = mailSender;
        this.fileName = fileName;
        this.inputStreamResource = inputStreamResource;
    }

    public MimeMessage toMimeMessage() throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper =
                new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true);

        if (inputStreamResource != null) {
            helper.addAttachment(fileName, inputStreamResource);
        }

        return message;
    }

    public void sendMessage() throws MessagingException {
        mailSender.send(toMimeMessage());
    }
}
