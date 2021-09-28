package com.mail_service.mailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.UnsupportedEncodingException;

@Component
public class MailgunSMTPConfig {
  @Autowired
    private JavaMailSender mailSender;

    public  void send (String to, String subject, String body) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        helper = new MimeMessageHelper(message,true);
   helper.setText(body, true);
   helper.setTo(to);
   helper.setSubject(subject);
   mailSender.send(message);
    }





//
////
////    @Value("${spring.mail.properties.mail.smtp.from}")
////    private String from;
//
////    @Value("${mail.from.name}")
////    private String fromName;
//
//    @Autowired
//    public MailgunSMTPConfig(JavaMailSender mailSender) {
//        this.mailSender = mailSender;
//    }
//
//
//    public void sendSimpleMessage(String to, String subject, String text) throws MessagingException, UnsupportedEncodingException {
//        MimeMessage message =  mailSender.createMimeMessage();
//
//        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
//        helper.setTo(to);
//        helper.setSubject(subject);
//        helper.setText(text, true);
////        helper.setFrom(new InternetAddress(from, fromName));
//
//        mailSender.send(message);
//    }
//
//    public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) throws MessagingException {
//        MimeMessage message = mailSender.createMimeMessage();
//
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//
//        helper.setTo(to);
//        helper.setSubject(subject);
//        helper.setText(text);
//
//        FileSystemResource file
//                = new FileSystemResource(new File(pathToAttachment));
//        helper.addAttachment("Invoice", file);
//
//        mailSender.send(message);
//    }

//    public static void sendAttachmentEmail( String toEmail, String subject, String body){
//        try{
//            MimeMessage msg = new MimeMessage(session);
//            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
//            msg.addHeader("format", "flowed");
//            msg.addHeader("Content-Transfer-Encoding", "8bit");
//
//            msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));
//            msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));
//            msg.setSubject(subject, "UTF-8");
//
//            msg.setSentDate(new Date());
//
//            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
//
//            // Create the message body part
//            BodyPart messageBodyPart = new MimeBodyPart();
//
//            // Fill the message
//            messageBodyPart.setText(body);
//
//            // Create a multipart message for attachment
//            Multipart multipart = new MimeMultipart();
//
//            // Set text message part
//            multipart.addBodyPart(messageBodyPart);
//
//            // Second part is attachment
//            messageBodyPart = new MimeBodyPart();
//            String filename = "abc.txt";
//            DataSource source = new FileDataSource(filename);
//            messageBodyPart.setDataHandler(new DataHandler(source));
//            messageBodyPart.setFileName(filename);
//            multipart.addBodyPart(messageBodyPart);
//
//            // Send the complete message parts
//            msg.setContent(multipart);
//
//            // Send message
//            Transport.send(msg);
//            System.out.println("EMail Sent Successfully with attachment!!");
//        }catch (MessagingException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }
}
