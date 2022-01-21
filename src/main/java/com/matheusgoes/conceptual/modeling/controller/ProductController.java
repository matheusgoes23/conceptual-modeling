package com.matheusgoes.conceptual.modeling.controller;

import com.matheusgoes.conceptual.modeling.dto.ProductDTO;
import com.matheusgoes.conceptual.modeling.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(productService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> save(@RequestBody @Valid ProductDTO productDTO) {
        return new ResponseEntity<>(productService.save(productDTO), HttpStatus.CREATED);
    }
}
