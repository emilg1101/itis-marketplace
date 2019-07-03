package com.github.emilg1101.marketplace.service;

import com.github.emilg1101.marketplace.data.entity.Product;
import com.github.emilg1101.marketplace.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(long id) {
        return productRepository.getOne(id);
    }
}
