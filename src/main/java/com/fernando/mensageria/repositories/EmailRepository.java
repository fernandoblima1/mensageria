package com.fernando.mensageria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fernando.mensageria.entities.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, Long>{
  
}
