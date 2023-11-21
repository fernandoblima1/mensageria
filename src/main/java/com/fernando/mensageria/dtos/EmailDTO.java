package com.fernando.mensageria.dtos;

import jakarta.validation.constraints.Email;
import com.fernando.mensageria.entities.EmailModel;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDTO {
    
  @NotBlank
  private String ownerRef;

  @NotBlank
  @Email
  private String emailFrom;
  
  @NotBlank
  @Email
  private String emailTo;
  
  @NotBlank  
  private String subject;
  
  @NotBlank
  private String text;

  public EmailModel toEmail() {
    return EmailModel.builder()
      .emailFrom(this.emailFrom)
      .emailTo(this.emailTo)
      .subject(this.subject)
      .text(this.text)
      .build();
  }

}
