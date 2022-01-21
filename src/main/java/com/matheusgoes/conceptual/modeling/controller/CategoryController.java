package com.matheusgoes.conceptual.modeling.controller;

import com.matheusgoes.conceptual.modeling.dto.CategoryDTO;
import com.matheusgoes.conceptual.modeling.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Page<CategoryDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(categoryService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> save(@RequestBody @Valid CategoryDTO categoryDTO) {
        return new ResponseEntity<>(categoryService.save(categoryDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
