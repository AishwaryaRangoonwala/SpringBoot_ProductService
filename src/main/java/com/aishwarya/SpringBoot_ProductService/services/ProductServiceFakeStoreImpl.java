package com.aishwarya.SpringBoot_ProductService.services;

import com.aishwarya.SpringBoot_ProductService.dtos.fakestore.FakeStoreCreateProductRequestDTO;
import com.aishwarya.SpringBoot_ProductService.dtos.fakestore.FakeStoreGetProductResponseDto;
import com.aishwarya.SpringBoot_ProductService.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
        FakeStoreGetProductResponseDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                request,
                FakeStoreGetProductResponseDto.class
        );


        return response.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        // Type Erasure
        // Java Generics; it does not know how to convert to List
        // List does not work; but array works
        // At the time of runtime, info present in the angular brackets is removed
        // i.e from List<FakeStoreGetProductResponseDto> FakeStoreProductResponseDto is removed
        // Java did that to maintain backward compatibility
        // At runtime, it became List<Object>
        // Code needs to convert it JSON to List<FakeStore>
        // But at runtime; it won't know object of what

        FakeStoreGetProductResponseDto[] response =
                restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreGetProductResponseDto[].class
        );
        List<FakeStoreGetProductResponseDto> responseDtoList =
                Stream.of(response).toList();
        List<Product> products = new ArrayList<>();
        for (FakeStoreGetProductResponseDto fakeStoreGetProductResponseDto : responseDtoList) {
            products.add(fakeStoreGetProductResponseDto.toProduct());
        }
        return products;
    }

    @Override
    public Product partialUpdateProduct(Long productId, Product product) {
        new RuntimeException();
//        HttpEntity<FakeStoreCreateProductRequestDTO> requestEntity = new HttpEntity<>(FakeStoreCreateProductRequestDTO);
//        ResponseEntity<FakeStoreGetProductResponseDto> responseEntity = restTemplate.exchange(
//                "https://fakestoreapi.com/products" + productId,
//                HttpMethod.PATCH,
//                requestEntity,
//                FakeStoreGetProductResponseDto.class);
//        return responseEntity.getBody().toProduct();
        return null;
    }
}
