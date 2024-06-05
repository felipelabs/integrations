package com.devsuperior.integrations.service;

import com.devsuperior.integrations.dto.SendEmailDTO;
import com.devsuperior.integrations.service.exceptions.SendEmailException;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SendEmailService {

    @Autowired
    private SendGrid sendGrid;

    public void sendEmail(SendEmailDTO sendEmailDTO){

        Email from = new Email(sendEmailDTO.getFromEmail(), sendEmailDTO.getFromName());
        Email to = new Email(sendEmailDTO.getTo());
        Content content = new Content(sendEmailDTO.getContentType(), sendEmailDTO.getBody());
        Mail mail = new Mail(from, sendEmailDTO.getSubject(), to, content);

        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGrid.api(request);
        }catch (IOException e){
            throw new SendEmailException(e.getMessage());
        }

    }
}
