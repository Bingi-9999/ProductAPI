package com.retail.Product.Controller;

import com.retail.Product.DTO.ProductDTO;
import com.retail.Product.Entity.Product;
import com.retail.Product.Service.ProductServiceAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/admin/v1")
public class ProductControllerAdmin {
    @Autowired
    private ProductServiceAdmin productServiceAdmin;

    @PostMapping("/products")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDto){

        ProductDTO created = productServiceAdmin.createProduct(productDto);
        URI location = URI.create("/products/" + created.id());
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/products")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDto){
        ProductDTO updated = productServiceAdmin.updateProduct(productDto);
        URI location = URI.create("/products/" + updated.id());
        return ResponseEntity.created(location).body(updated);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<ProductDTO> deleteProduct(@PathVariable Long id){
        ProductDTO productDTO = productServiceAdmin.deleteProduct(id);

        if(productDTO.id() == null){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(productDTO);

    }

    @PutMapping("/products/{id}/{quantity}")
    public ResponseEntity<ProductDTO> updateQuantity(@PathVariable Long id, @PathVariable Integer quantity){
        ProductDTO product = productServiceAdmin.updateQuantity(id, quantity);

        return ResponseEntity.ok(product);
    }
}
