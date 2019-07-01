package com.github.emilg1101.marketplace.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductModel {
    boolean loggedIn;
    long id;
    String imageURL;
    String title;
    String description;
    double price;
}
