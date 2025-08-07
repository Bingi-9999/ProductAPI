package com.retail.Product.Service;

import com.retail.Product.DTO.ProductDTO;
import com.retail.Product.DTO.ProductMapper;
import com.retail.Product.Entity.Product;
import com.retail.Product.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceAdmin {
    @Autowired
    private ProductRepo productRepo;

    public ProductDTO deleteProduct(Long id) {

        Product product = productRepo.findById(id).orElse(new Product());

        productRepo.delete(product);

        return ProductMapper.mapper(product);

    }


    public ProductDTO createProduct(ProductDTO productDto) {
        Product product = new Product();

        product.setCategory(productDto.category());
        product.setDescription(productDto.description());
        product.setName(productDto.name());
        product.setPrice(productDto.price());
        product.setQuantity(productDto.quantity());

        Product create = productRepo.save(product);

        ProductDTO created = ProductMapper.mapper(create);

        return created;


    }

    public ProductDTO updateProduct(ProductDTO productDto) {
        Product product = productRepo.findById(productDto.id()).orElse(new Product());

        product.setCategory(productDto.category());
        product.setDescription(productDto.description());
        product.setName(productDto.name());
        product.setPrice(productDto.price());
        product.setQuantity(productDto.quantity());

        Product update = productRepo.save(product);

        return ProductMapper.mapper(update);
    }

    public ProductDTO updateQuantity(Long id, Integer quantity) {
        Product pro = productRepo.findById(id).orElse(new Product());

        if(pro.getId() == null){
            return ProductMapper.mapper(pro);
        }

        pro.setQuantity(pro.getQuantity()-quantity);

        productRepo.save(pro);

        return ProductMapper.mapper(pro);
    }
}
