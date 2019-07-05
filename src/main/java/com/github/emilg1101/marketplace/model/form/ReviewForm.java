package com.github.emilg1101.marketplace.model.form;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewForm {
    long productId;
    String text;
}
