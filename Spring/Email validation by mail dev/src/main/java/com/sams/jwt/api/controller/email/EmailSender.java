package com.sams.jwt.api.controller.email;

public interface EmailSender {
    void send(String to, String email);
}
