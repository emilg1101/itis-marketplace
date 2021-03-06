package com.github.emilg1101.marketplace.model.account;

import com.github.emilg1101.marketplace.data.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewItemModel {
    long id;
    String text;
    String reviewTime;
    long productId;
    String productImageURL;
    String productTitle;

    public static ReviewItemModel map(Review review) {
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        return ReviewItemModel.builder()
                .id(review.getId())
                .text(review.getText())
                .reviewTime(ft.format(review.getReviewTime()))
                .productId(review.getProduct().getId())
                .productImageURL(review.getProduct().getImageURL())
                .productTitle(review.getProduct().getTitle())
                .build();
    }
}
