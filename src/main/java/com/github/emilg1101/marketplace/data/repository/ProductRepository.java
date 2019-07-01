package com.github.emilg1101.marketplace.data.repository;

import com.github.emilg1101.marketplace.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
