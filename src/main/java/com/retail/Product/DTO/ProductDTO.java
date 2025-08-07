package com.retail.Product.DTO;

import com.retail.Product.Entity.ProductCategory;
import java.math.BigDecimal;


public record ProductDTO(
        Long id,
        String name,
        String description,
        BigDecimal price,
        ProductCategory category,
        Integer quantity
) {
}
