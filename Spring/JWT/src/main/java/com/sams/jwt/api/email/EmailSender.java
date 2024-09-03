package com.sams.jwt.api.email;

public interface EmailSender {
    void send(String to, String email);
}
