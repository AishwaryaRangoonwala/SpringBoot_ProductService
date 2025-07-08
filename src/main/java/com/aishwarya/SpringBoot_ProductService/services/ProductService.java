package com.aishwarya.SpringBoot_ProductService.services;

import com.aishwarya.SpringBoot_ProductService.models.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(
            Product product
    );

    List<Product> getAllProducts();

    Product partialUpdateProduct(Long productId, Product product);
}
