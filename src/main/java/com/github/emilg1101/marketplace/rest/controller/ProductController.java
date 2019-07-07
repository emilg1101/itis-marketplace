package com.github.emilg1101.marketplace.rest.controller;

import com.github.emilg1101.marketplace.data.entity.Product;
import com.github.emilg1101.marketplace.data.repository.ProductRepository;
import com.github.emilg1101.marketplace.rest.exception.EntityNotFoundException;
import com.github.emilg1101.marketplace.rest.entity.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("/api/products")
    @ResponseBody
    List<ProductResponse> products() {
        return repository.findAll()
                .stream()
                .map(ProductResponse::map)
                .collect(Collectors.toList());
    }

    @GetMapping("/api/product/{id}")
    ProductResponse product(@PathVariable Long id) {
        return ProductResponse.map(repository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @PostMapping("/api/product")
    ProductResponse add(@RequestBody ProductResponse productResponse) {
        Product product = Product.builder()
                .title(productResponse.getTitle())
                .description(productResponse.getDescription())
                .imageURL(productResponse.getImageURL())
                .price(productResponse.getPrice())
                .build();
        return ProductResponse.map(repository.save(product));
    }

    @PutMapping("/api/product/{id}")
    ProductResponse update(@RequestBody ProductResponse productResponse, @PathVariable Long id) {
        Product product = Product.builder()
                .id(id)
                .title(productResponse.getTitle())
                .description(productResponse.getDescription())
                .imageURL(productResponse.getImageURL())
                .price(productResponse.getPrice())
                .build();
        return ProductResponse.map(repository.save(product));
    }

    @DeleteMapping("/api/product/{id}")
    void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
