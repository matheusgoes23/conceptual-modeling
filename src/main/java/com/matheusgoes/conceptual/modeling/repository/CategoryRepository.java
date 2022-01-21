package com.matheusgoes.conceptual.modeling.repository;

import com.matheusgoes.conceptual.modeling.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
