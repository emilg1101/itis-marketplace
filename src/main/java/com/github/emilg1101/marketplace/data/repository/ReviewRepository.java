package com.github.emilg1101.marketplace.data.repository;

import com.github.emilg1101.marketplace.data.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
