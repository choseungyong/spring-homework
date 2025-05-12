package com.domain.app.product;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService {

    private final Map<Long,ProductDto> products = new HashMap<>();

    private final AtomicLong sequence = new AtomicLong(1001);

    public ProductDto findById(Long id){
        return products.get(id);
    }

    public ProductDto save(ProductDto dto){
        Long id = sequence.getAndIncrement();

        ProductDto saved = ProductDto.builder()
                .id(id)
                .name(dto.getName())
                .price(dto.getPrice())
                .imageUrl(dto.getImageUrl())
                .build();

        products.put(id, saved);
        return saved;
    }

    public ProductDto update(Long id, ProductDto dto){

        ProductDto updated = ProductDto.builder()
                .id(id)
                .name(dto.getName())
                .price(dto.getPrice())
                .imageUrl(dto.getImageUrl())
                .build();

        products.put(id,updated);
        return updated;
    }

    public void delete(Long id){
        products.remove(id);
    }
}
