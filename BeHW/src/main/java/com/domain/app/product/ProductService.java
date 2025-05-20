package com.domain.app.product;

import com.domain.app.product.domain.Product;
import com.domain.app.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id){
        return productRepository.findById(id).orElseThrow();
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public Product update(Long id, Product Data){
        Product existing = productRepository.findById(id).orElseThrow();
        existing = Product.builder()
                .id(id)
                .name(Data.getName())
                .price(Data.getPrice())
                .imageUrl(Data.getImageUrl())
                .build();
        return productRepository.save(existing);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }
}
