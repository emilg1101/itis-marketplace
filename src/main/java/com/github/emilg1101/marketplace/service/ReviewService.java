package com.github.emilg1101.marketplace.service;

import com.github.emilg1101.marketplace.data.entity.Product;
import com.github.emilg1101.marketplace.data.entity.Review;
import com.github.emilg1101.marketplace.data.entity.User;
import com.github.emilg1101.marketplace.data.repository.ReviewRepository;
import com.github.emilg1101.marketplace.model.form.ReviewForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductService productService;

    public Review add(ReviewForm form, User user) {
        Product product = productService.getProduct(form.getProductId());
        Review review = Review.builder()
                .text(form.getText())
                .reviewTime(Date.from(Instant.now()))
                .user(user)
                .product(product)
                .build();
        return reviewRepository.save(review);
    }

    public void delete(long reviewId, User user) {
        Optional<Review> reviewCandidate = reviewRepository.findById(reviewId);

        if (reviewCandidate.isPresent()) {
            Review review = reviewCandidate.get();
            if (review.getUser().getId().equals(user.getId())) {
                reviewRepository.delete(review);
            } else {
                throw new EntityNotFoundException();
            }
        } else {
            throw new EntityNotFoundException();
        }
    }
}
