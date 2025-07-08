package com.aishwarya.SpringBoot_ProductService.dtos.fakestore;

import com.aishwarya.SpringBoot_ProductService.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreCreateProductRequestDTO {
    private String title;
    private double price;
    private String image;
    private String description;
    private String category;

    public static FakeStoreCreateProductRequestDTO from(Product product) {
        FakeStoreCreateProductRequestDTO fakeStoreCreateProductRequestDTO = new FakeStoreCreateProductRequestDTO();
        fakeStoreCreateProductRequestDTO.title = product.getTitle();
        fakeStoreCreateProductRequestDTO.price = product.getPrice();
        fakeStoreCreateProductRequestDTO.image = product.getImageUrl();
        fakeStoreCreateProductRequestDTO.description = product.getDescription();
        fakeStoreCreateProductRequestDTO.category = product.getCategoryName();
        return fakeStoreCreateProductRequestDTO;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
