package com.example.securite.Service;

public interface IEmail {
    
    public void sendSimpleMessage(
            String to, String subject, String text);

}
