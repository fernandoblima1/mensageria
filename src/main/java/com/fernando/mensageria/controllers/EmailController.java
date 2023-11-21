package com.fernando.mensageria.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fernando.mensageria.dtos.EmailDTO;
import com.fernando.mensageria.entities.EmailModel;
import com.fernando.mensageria.enums.StatusEmail;
import com.fernando.mensageria.services.EmailService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Email")
@RestController
@RequiredArgsConstructor
public class EmailController {
  
  private final EmailService emailService;

  @PostMapping("/send-email")
  public ResponseEntity<EmailModel> sendEmail(@RequestBody @Valid EmailDTO emailDTO) {
    EmailModel emailModel = emailDTO.toEmail();
    try {
      emailService.sendEmail(emailModel);
    } catch (Exception e) {
      emailModel.setStatus(StatusEmail.ERROR);
    }
    return ResponseEntity.ok(emailModel);
  }

}
