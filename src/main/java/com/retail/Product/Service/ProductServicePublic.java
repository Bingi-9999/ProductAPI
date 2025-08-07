package com.retail.Product.Service;

import com.retail.Product.DTO.ProductDTO;
import com.retail.Product.Entity.Product;
import com.retail.Product.Entity.ProductCategory;
import com.retail.Product.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServicePublic {

    @Autowired
    private ProductRepo productRepo;

    public List<ProductDTO> getAllProducts() {
        return productRepo.findAll()
                .stream()
                .map(product -> new ProductDTO(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getCategory(),
                        product.getQuantity()
                ))
                .sorted(Comparator.comparing(ProductDTO::name))
                .collect(Collectors.toList());
    }

    public void addProduct(Product product) {
        productRepo.save(product);
    }

    public ProductDTO getProduct(Long id) {
        Product product = productRepo.findById(id).orElse(new Product());

        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory(),
                product.getQuantity()
        );
    }

    public List<ProductDTO> getProductsWithFilter(ProductCategory category) {
        List<Product> product = productRepo.findByCategory(category);
        return product.stream()
                .map(product1 -> new ProductDTO(
                        product1.getId(),
                        product1.getName(),
                        product1.getDescription(),
                        product1.getPrice(),
                        product1.getCategory(),
                        product1.getQuantity()
                ))
                .sorted(Comparator.comparing(ProductDTO::name))
                .collect(Collectors.toList());
    }
}
