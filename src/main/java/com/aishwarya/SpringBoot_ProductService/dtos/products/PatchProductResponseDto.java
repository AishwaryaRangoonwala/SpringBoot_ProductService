package com.aishwarya.SpringBoot_ProductService.dtos.products;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatchProductResponseDto {
    private GetProductDto product;

    public GetProductDto getProduct() {
        return product;
    }

    public void setProduct(GetProductDto product) {
        this.product = product;
    }
}
