package com.fernando.mensageria.entities;

import java.time.LocalDateTime;

import com.fernando.mensageria.enums.StatusEmail;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_email")
@Builder
public class EmailModel {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String ownerRef;

  private String emailFrom;

  private String emailTo;

  private String subject;

  @Column(columnDefinition = "TEXT")
  private String text;

  private LocalDateTime sendDateEmail;

  private LocalDateTime receivedDateEmail;

  private StatusEmail status;
}
