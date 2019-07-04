package com.github.emilg1101.marketplace.data.repository;

import com.github.emilg1101.marketplace.data.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
