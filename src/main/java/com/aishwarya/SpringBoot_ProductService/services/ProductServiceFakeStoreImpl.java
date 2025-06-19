package com.aishwarya.SpringBoot_ProductService.services;

import com.aishwarya.SpringBoot_ProductService.dtos.FakeStoreCreateProductRequestDTO;
import com.aishwarya.SpringBoot_ProductService.dtos.FakeStoreCreateProductResponseDto;
import com.aishwarya.SpringBoot_ProductService.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
@Primary
public class ProductServiceFakeStoreImpl implements ProductService {

    private RestTemplate restTemplate;

    @Autowired
    public ProductServiceFakeStoreImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreCreateProductRequestDTO request = new FakeStoreCreateProductRequestDTO();
        request.setCategory(product.getCategoryName());
        request.setTitle(product.getTitle());
        request.setImage(product.getImageUrl());
        request.setPrice(product.getPrice());
        request.setDescription(product.getDescription());
        FakeStoreCreateProductResponseDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                request,
                FakeStoreCreateProductResponseDto.class
        );
        Product product1 = new Product();
        product1.setId(response.getId());
        product1.setTitle(response.getTitle());
        product1.setDescription(response.getDescription());
        product1.setImageUrl(response.getImage());
        product1.setCategoryName(request.getCategory());
        product1.setPrice(response.getPrice());

        return product1;
    }
}
