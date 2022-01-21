package com.matheusgoes.conceptual.modeling.dto;

import com.matheusgoes.conceptual.modeling.model.Category;
import com.matheusgoes.conceptual.modeling.model.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank
    private String name;
    private Set<ProductDTO> products = new HashSet<>();

    public CategoryDTO(Category entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public CategoryDTO(Category entity, Set<Product> products) {
        this(entity);
        products.forEach(product -> this.products.add(new ProductDTO(product)));
    }

    public static Category toEntity(CategoryDTO categoryDTO) {
        Category category = new Category();
        Set<Product> products = new HashSet<>();

        BeanUtils.copyProperties(categoryDTO, category);
        categoryDTO.getProducts().forEach(prod -> products.add(ProductDTO.toEntity(prod)));
        category.setProducts(products);

        return category;
    }
}
