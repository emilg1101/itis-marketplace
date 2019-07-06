package com.github.emilg1101.marketplace.service;

import com.github.emilg1101.marketplace.data.entity.Product;
import com.github.emilg1101.marketplace.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(long id) {
        Optional<Product> productCandidate = productRepository.findById(id);
        if (productCandidate.isPresent()) {
            return productCandidate.get();
        }
        throw new EntityNotFoundException();
    }
}
