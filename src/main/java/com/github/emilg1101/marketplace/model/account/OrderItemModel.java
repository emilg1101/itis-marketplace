package com.github.emilg1101.marketplace.model.account;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItemModel {
    long id;
    String status;
    String orderTime;
    double amount;
    long productId;
    String productImageURL;
    int productQuantity;
    String productTitle;
    double productPrice;
}
