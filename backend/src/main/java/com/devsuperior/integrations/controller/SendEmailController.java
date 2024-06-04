package com.devsuperior.integrations.controller;

import com.devsuperior.integrations.dto.SendEmailDTO;
import com.devsuperior.integrations.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/emails")
public class SendEmailController {

    @Autowired
    SendEmailService sendEmailService;

    @PostMapping
    public ResponseEntity<Void> sendEmail(@RequestBody SendEmailDTO sendEmailDTO){
        sendEmailService.sendEmail(sendEmailDTO);
        return ResponseEntity.noContent().build();
    }
}
