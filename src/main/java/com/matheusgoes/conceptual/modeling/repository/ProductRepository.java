package com.matheusgoes.conceptual.modeling.repository;

import com.matheusgoes.conceptual.modeling.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
