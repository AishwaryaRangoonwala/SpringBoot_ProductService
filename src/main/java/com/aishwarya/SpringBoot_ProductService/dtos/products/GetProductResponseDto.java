package com.aishwarya.SpringBoot_ProductService.dtos.products;

import com.aishwarya.SpringBoot_ProductService.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductResponseDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String imageUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static GetProductResponseDto from(Product product) {
        GetProductResponseDto getProductResponseDto = new GetProductResponseDto();
        getProductResponseDto.setId(product.getId());
        getProductResponseDto.setTitle(product.getTitle());
        getProductResponseDto.setDescription(product.getDescription());
        getProductResponseDto.setPrice(product.getPrice());
        getProductResponseDto.setImageUrl(product.getImageUrl());
        return getProductResponseDto;
    }
}
