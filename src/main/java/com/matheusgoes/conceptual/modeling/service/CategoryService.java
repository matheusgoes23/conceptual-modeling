package com.matheusgoes.conceptual.modeling.service;

import com.matheusgoes.conceptual.modeling.dto.CategoryDTO;
import com.matheusgoes.conceptual.modeling.exception.ObjectNotFoundException;
import com.matheusgoes.conceptual.modeling.model.Category;
import com.matheusgoes.conceptual.modeling.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAll(Pageable pageable) {
        Page<Category> page = categoryRepository.findAll(pageable);
        return page.map(category -> new CategoryDTO(category, category.getProducts()));
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()) {
            throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Category.class.getName());
        }
        return new CategoryDTO(category.get(), category.get().getProducts());
    }

    @Transactional
    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = categoryRepository.save(CategoryDTO.toEntity(categoryDTO));
        return new CategoryDTO(category, category.getProducts());
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
