package com.domain.app.product;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductDto {

    private long id;
    private String name;
    private int price;
    private String imageUrl;

    @Builder
    public ProductDto(Long id, String name, int price, String imageUrl){
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }
}
