package com.matheusgoes.conceptual.modeling.service;

import com.matheusgoes.conceptual.modeling.dto.ProductDTO;
import com.matheusgoes.conceptual.modeling.exception.ObjectNotFoundException;
import com.matheusgoes.conceptual.modeling.model.Category;
import com.matheusgoes.conceptual.modeling.model.Product;
import com.matheusgoes.conceptual.modeling.repository.CategoryRepository;
import com.matheusgoes.conceptual.modeling.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> page = productRepository.findAll(pageable);
        return page.map(product -> new ProductDTO(product, product.getCategories()));
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Product.class.getName());
        }
        return new ProductDTO(product.get(), product.get().getCategories());
    }

    @Transactional
    public ProductDTO save(ProductDTO productDTO) {
        Set<Category> categories = new HashSet<>();
        Product product = productRepository.save(ProductDTO.toEntity(productDTO));
        product.getCategories().forEach(category -> categories.add(categoryRepository.findById(category.getId()).get()));
        return new ProductDTO(product, categories);
    }
}
