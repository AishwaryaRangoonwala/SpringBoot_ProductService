package com.aishwarya.SpringBoot_ProductService.services;

import com.aishwarya.SpringBoot_ProductService.models.Product;
import org.springframework.stereotype.Service;

@Service("dbProductService")
public class ProductServiceDBImpl implements ProductService {

    @Override
    public Product createProduct(Product product) {
        return null;
    }
}
