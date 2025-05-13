package com.domain.app.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productservice;

    @GetMapping
    public List<ProductDto> getAll() {
        return productservice.getAll();
    }

    @GetMapping("/{id}")
    public ProductDto getInfo(@PathVariable Long id){
        return productservice.findById(id);
    }

    @PostMapping
    public ProductDto create(@RequestBody ProductDto dto) {
        return productservice.save(dto);
    }

    @PutMapping("/{id}")
    public ProductDto update(@PathVariable Long id, @RequestBody ProductDto dto){
        return productservice.update(id,dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        productservice.delete(id);
    }
}
