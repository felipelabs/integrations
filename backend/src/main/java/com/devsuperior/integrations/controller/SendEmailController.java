package com.devsuperior.integrations.controller;

import com.devsuperior.integrations.dto.SendEmailDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/emails")
public class SendEmailController {

    @PostMapping
    public ResponseEntity<Void> sendEmail(@RequestBody SendEmailDTO sendEmailDTO){
        return ResponseEntity.noContent().build();
    }
}
