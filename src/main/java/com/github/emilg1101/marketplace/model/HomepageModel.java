package com.github.emilg1101.marketplace.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class HomepageModel {
    boolean loggedIn;
    List<ProductItemModel> products;
}
