package com.matheusgoes.conceptual.modeling.dto;

import com.matheusgoes.conceptual.modeling.model.Category;
import com.matheusgoes.conceptual.modeling.model.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class ProductDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank
    private String name;

    @PositiveOrZero
    private Double price;

    @NotEmpty
    private Set<CategoryDTO> categories = new HashSet<>();

    public ProductDTO(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
    }

    public ProductDTO(Product entity, Set<Category> categories) {
        this(entity);
        categories.forEach(category -> this.categories.add(new CategoryDTO(category)));
    }

    public static Product toEntity(ProductDTO productDTO) {
        Product product = new Product();
        Set<Category> categories = new HashSet<>();

        BeanUtils.copyProperties(productDTO, product);
        productDTO.getCategories().forEach(cat -> categories.add(CategoryDTO.toEntity(cat)));
        product.setCategories(categories);

        return product;
    }
}
