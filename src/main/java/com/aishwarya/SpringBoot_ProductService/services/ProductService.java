package com.aishwarya.SpringBoot_ProductService.services;

import com.aishwarya.SpringBoot_ProductService.models.Product;

public interface ProductService {
    Product createProduct(
            Product product
    );
}
