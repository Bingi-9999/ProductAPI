package com.retail.Product.Repository;

import com.retail.Product.Entity.Product;
import com.retail.Product.Entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByCategory(ProductCategory category);
}
