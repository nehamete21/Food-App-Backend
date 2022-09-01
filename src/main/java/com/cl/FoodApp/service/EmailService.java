package com.cl.FoodApp.service;

import com.cl.FoodApp.dto.EmailDetails;

// Importing required classes
 
// Interface
public interface EmailService {
 
    // Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);
 
    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);
}