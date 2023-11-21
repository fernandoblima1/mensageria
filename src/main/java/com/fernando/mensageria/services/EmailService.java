package com.fernando.mensageria.services;

import java.time.LocalDateTime;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.fernando.mensageria.entities.EmailModel;
import com.fernando.mensageria.enums.StatusEmail;
import com.fernando.mensageria.repositories.EmailRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {
  
  private final EmailRepository emailRepository;
  private final JavaMailSender mailSender;

  @Transactional
  public void sendEmail(EmailModel emailModel) {
    emailModel.setSendDateEmail(LocalDateTime.now());
    try {
      SimpleMailMessage message = new SimpleMailMessage();
      message.setFrom(emailModel.getEmailFrom());
      message.setTo(emailModel.getEmailTo());
      message.setSubject(emailModel.getSubject());
      message.setText(emailModel.getText());
      mailSender.send(message);
      emailModel.setStatus(StatusEmail.SENT);
    } catch (Exception e) {
      emailModel.setStatus(StatusEmail.ERROR);
    } finally {
      emailRepository.save(emailModel);
    }
  }

}
