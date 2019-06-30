package com.github.emilg1101.marketplace.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderModel {
    long productId;
    String productImageURL;
    String productTitle;
    double productPrice;
    List<AddressItemModel> addresses;
}
