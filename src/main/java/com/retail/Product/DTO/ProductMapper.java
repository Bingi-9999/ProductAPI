package com.retail.Product.DTO;

import com.retail.Product.Entity.Product;

public class ProductMapper {
    public static ProductDTO mapper(Product product){
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory(),
                product.getQuantity()
        );
    }
}
