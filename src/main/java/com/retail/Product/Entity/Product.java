package com.retail.Product.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;




@Entity

public class Product extends ProductBaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 500)
    private String description;
    @DecimalMin(value = "1", inclusive = true)
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductCategory category;
    @Column(nullable = false)
    @DecimalMin(value = "0", inclusive = true)
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public @DecimalMin(value = "1", inclusive = true) BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@DecimalMin(value = "1", inclusive = true) BigDecimal price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public @DecimalMin(value = "0", inclusive = true) Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(@DecimalMin(value = "0", inclusive = true) Integer quantity) {
        this.quantity = quantity;
    }
}
