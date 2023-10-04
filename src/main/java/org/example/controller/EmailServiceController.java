package org.example.controller;

import org.example.service.EmailService;
import org.example.models.EmailReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="email")
public class EmailServiceController {

    @Autowired
    EmailService emailService;
    @PostMapping(value="send")
    public ResponseEntity<String> sendmail(EmailReqDTO emailReqDTO){
      String message =  emailService.sendMail(emailReqDTO);
      return new ResponseEntity<>("Mail sent", HttpStatus.OK);

    }

    @PostMapping(value="sendAttachment")
    public ResponseEntity<String> sendmailWithAttachment(EmailReqDTO emailReqDTO){
        String message =  emailService.sendMailWithAttachment(emailReqDTO);
        return new ResponseEntity<>("Mail sent", HttpStatus.OK);

    }
}
