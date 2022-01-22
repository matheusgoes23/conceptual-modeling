package com.matheusgoes.conceptual.modeling.repository;

import com.matheusgoes.conceptual.modeling.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
