package com.retail.Product.Controller;

import com.retail.Product.DTO.ProductDTO;
import com.retail.Product.Entity.Product;
import com.retail.Product.Entity.ProductCategory;
import com.retail.Product.Service.ProductServicePublic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/v1")
public class ProductControllerPublic {

    @Autowired
    private ProductServicePublic productServicePublic;

    @GetMapping("/")
    public String greet(){
       return "Welcome to product Application";

    }
    
    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getProducts(){
        List<ProductDTO> productDTO = productServicePublic.getAllProducts();

        return ResponseEntity.status(HttpStatus.OK).body(productDTO);

    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id){
        ProductDTO productDto = productServicePublic.getProduct(id);

        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @GetMapping("/productsFilter")
    public ResponseEntity<List<ProductDTO>> getProductsWithFilter(@RequestParam(required = false) ProductCategory category){
        List<ProductDTO> productDTO = productServicePublic.getProductsWithFilter(category);

        return ResponseEntity.status(HttpStatus.OK).body(productDTO);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product){
        productServicePublic.addProduct(product);
    }


}
