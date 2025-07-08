package com.aishwarya.SpringBoot_ProductService.controllers;

import com.aishwarya.SpringBoot_ProductService.dtos.ErrorResponseDto;
import com.aishwarya.SpringBoot_ProductService.dtos.products.*;
import com.aishwarya.SpringBoot_ProductService.models.Product;
import com.aishwarya.SpringBoot_ProductService.services.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public GetAllProductsResponseDto getAllProducts() {
//        List<Product> products = productService.getAllProducts();
//        List<GetProductResponseDto> productList = new ArrayList<>();
//        for (Product product : products) {
//            productList.add(GetProductResponseDto.from(product));
//        }
//        return productList;
        List<Product> products = productService.getAllProducts();
        GetAllProductsResponseDto response = new GetAllProductsResponseDto();
        List<GetProductDto> getProductResponseDtos = new ArrayList<>();
        for(Product product : products) {
            getProductResponseDtos.add(GetProductDto.from(product));
        }
        response.setProducts(getProductResponseDtos);
        return response;
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
    @PatchMapping("/{id}")
    public PatchProductResponseDto updateProduct(
            @PathVariable("id") Long productId,
            @RequestBody CreateProductDto productDto) {
        Product product = productService.partialUpdateProduct(
                productId, productDto.toProduct() );
        PatchProductResponseDto response = new PatchProductResponseDto();
        response.setProduct(GetProductDto.from(product));
        return response;
    }


//    public void updateProduct() {
//
//    }
//
//    public void replaceProduct() {
//
//    }
}
