package com.matheusgoes.conceptual.modeling.repository;

import com.matheusgoes.conceptual.modeling.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}