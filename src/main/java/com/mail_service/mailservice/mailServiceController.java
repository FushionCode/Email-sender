package com.mail_service.mailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping
public class mailServiceController {

    @Autowired
   private MailgunSMTPConfig mailsender;


    @GetMapping("/send-via-smtp")
    public void sendTestEmail() throws MessagingException {
    mailsender.send("himole22@gmail.com", "first Test Email",
                "this is a test email for an api using mailgun.");
    }
}
