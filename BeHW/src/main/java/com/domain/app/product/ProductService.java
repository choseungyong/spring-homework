package com.domain.app.product;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    private final Map<Long,ProductDto> products = new HashMap<>();
    private long sequence = 1L;

    public List<ProductDto> getAll() {
        return new ArrayList<>(products.values());
    }

    public ProductDto findById(Long id){
        return products.get(id);
    }

    public ProductDto save(ProductDto dto){
        Long Id = sequence++;
        ProductDto saved = ProductDto.builder()
                .id(Id)
                .name(dto.getName())
                .price(dto.getPrice())
                .imageUrl(dto.getImageUrl())
                .build();

        products.put(Id, saved);
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
