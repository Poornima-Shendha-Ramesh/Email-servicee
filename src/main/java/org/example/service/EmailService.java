package org.example.service;

import org.example.models.EmailReqDTO;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    String sendMail(EmailReqDTO emailReqDTO);

    String sendMailWithAttachment(EmailReqDTO emailReqDTO);
}
