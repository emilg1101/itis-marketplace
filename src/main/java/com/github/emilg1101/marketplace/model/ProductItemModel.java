package com.github.emilg1101.marketplace.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductItemModel {
    long id;
    String imageURL;
    String title;
    String description;
    double price;
}