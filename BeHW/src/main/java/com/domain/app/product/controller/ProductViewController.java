package com.domain.app.product.controller;

import com.domain.app.product.dto.ProductRequestDto;
import com.domain.app.product.dto.ProductResponseDto;
import com.domain.app.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/products")
public class ProductViewController {

    private final ProductService productservice;

    @GetMapping
    public String list(Model model) {
        List<ProductResponseDto> products = productservice.getAll();
        model.addAttribute("products", products);
        return "products/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("product", new ProductRequestDto());
        return "products/form";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        ProductResponseDto product = productservice.findById(id);
        ProductRequestDto dto = new ProductRequestDto(product.getName(), product.getPrice(), product.getImageUrl());
        model.addAttribute("product", dto);
        model.addAttribute("productId", id);
        return "products/form";
    }

    @PostMapping
    public String save(@ModelAttribute("product") @Valid ProductRequestDto productDto,
                       BindingResult result) {
        if (result.hasErrors()) {
            return "products/form";
        }

        productservice.save(productDto);
        return "redirect:/admin/products";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id,
                         @ModelAttribute("product") @Valid ProductRequestDto productDto,
                         BindingResult result,
                         Model model) {
        if (result.hasErrors()) {
            model.addAttribute("productId", id);
            return "products/form";
        }

        productservice.update(id, productDto);
        return "redirect:/admin/products";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        productservice.delete(id);
        return "redirect:/admin/products";
    }
}
