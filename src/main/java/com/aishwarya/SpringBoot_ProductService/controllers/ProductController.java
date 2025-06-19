package com.aishwarya.SpringBoot_ProductService.controllers;

import com.aishwarya.SpringBoot_ProductService.dtos.CreateProductRequestDto;
import com.aishwarya.SpringBoot_ProductService.dtos.CreateProductResponseDto;
import com.aishwarya.SpringBoot_ProductService.models.Product;
import com.aishwarya.SpringBoot_ProductService.services.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(@Value("${productService}") String productServiceName,
                             ApplicationContext applicationContext) {
        this.productService = applicationContext.getBean(productServiceName, ProductService.class);
    }


//    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
//        this.productService = productService;
//    }

    @PostMapping("")
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto) {
        Product product = productService.createProduct(
                createProductRequestDto.toProduct()
        );
        return CreateProductResponseDto.fromProduct(product);
    }

    @GetMapping("")
    public void getAllProducts() {

    }

    @GetMapping("/products/{id}")
    public String getSingleProduct(@PathVariable("id") Long id) {
        return "Here is your product " + id;
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct() {

    }

    @RequestMapping(name = "NAMAN", value = "")
    public String test() {
        return "Magic";
    }


//    public void updateProduct() {
//
//    }
//
//    public void replaceProduct() {
//
//    }
}
