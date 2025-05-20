package com.domain.app.product;

import com.domain.app.product.domain.Product;
import com.domain.app.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productservice;

    @GetMapping
    public List<Product> getAll() {
        return productservice.getAll();
    }

    @GetMapping("/{id}")
    public Product getInfo(@PathVariable Long id){
        return productservice.findById(id);
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productservice.save(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product){
        return productservice.update(id,product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        productservice.delete(id);
    }
}
