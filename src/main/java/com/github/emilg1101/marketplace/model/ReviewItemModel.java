package com.github.emilg1101.marketplace.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewItemModel {
    long id;
    String text;
    String reviewTime;
    long productId;
    String productImageURL;
    String productTitle;
}
