package com.matheusgoes.conceptual.modeling.repository;

import com.matheusgoes.conceptual.modeling.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
