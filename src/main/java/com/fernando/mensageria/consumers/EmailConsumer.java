package com.fernando.mensageria.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fernando.mensageria.dtos.EmailDTO;
import com.fernando.mensageria.entities.EmailModel;
import com.fernando.mensageria.services.EmailService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmailConsumer {
  
  private final EmailService emailService;
  
  @RabbitListener(queues = "${spring.rabbitmq.queue}")
  public void listen(@Payload EmailDTO emailDTO) {
    EmailModel emailModel = emailDTO.toEmail();
    emailService.sendEmail(emailModel);
    log.info("Email status: {}", emailModel.getStatus().toString());
  }

}
