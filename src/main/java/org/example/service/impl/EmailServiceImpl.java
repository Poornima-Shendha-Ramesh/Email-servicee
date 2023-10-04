package org.example.service.impl;

import jakarta.mail.internet.MimeMessage;
import org.example.models.EmailReqDTO;
import org.example.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    JavaMailSender javaMailSender;
*
    private String sender;
    @Override
    public String sendMail(EmailReqDTO emailReqDTO) {
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom("poornima");
            mailMessage.setTo(emailReqDTO.getRecipient());
            mailMessage.setText(emailReqDTO.getMsgBody());
            mailMessage.setSubject(emailReqDTO.getSubject());

            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }

    @Override
    public String sendMailWithAttachment(EmailReqDTO emailReqDTO) {
            MimeMessage mimeMessage
                = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {

            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper
                    = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom("poornima");
            mimeMessageHelper.setTo(emailReqDTO.getRecipient());
            mimeMessageHelper.setText(emailReqDTO.getMsgBody());
            mimeMessageHelper.setSubject(
                    emailReqDTO.getSubject());

            // Adding the attachment
            FileSystemResource file
                    = new FileSystemResource(
                    new File(emailReqDTO.getAttachment()));

            mimeMessageHelper.addAttachment(
                    file.getFilename(), file);

            // Sending the mail
            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully";
        }


        catch (Exception e) {

            return "Error while sending mail!!!";
        }
    }
}
