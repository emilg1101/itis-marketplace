package com.github.emilg1101.marketplace.model;

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
    String text;
    String reviewTime;
    String author;

    public static ReviewItemModel map(Review review) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm");
        return ReviewItemModel.builder()
                .text(review.getText())
                .reviewTime(ft.format(review.getReviewTime()))
                .author(review.getUser().getName())
                .build();
    }
}
