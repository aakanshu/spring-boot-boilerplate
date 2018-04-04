package com.springboilerplate.springboilerplate.dto;


import java.util.Date;

public class MessageDto {
    private String from;
    private String to;
    private String content;
    private Date time;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        if (time == null) {
            return null;
        }
        return new Date(time.getTime());
    }

    public void setTime(Date time) {
        if (time != null) {
            this.time = new Date(time.getTime());
        } else {
            this.time = null;
        }
    }

    public MessageDto(String from, String content, Date time) {
        this.from = from;
        this.content = content;
        this.time = new Date(time.getTime());
    }

    public MessageDto() {
    }
}
