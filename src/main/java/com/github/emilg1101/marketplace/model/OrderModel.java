package com.github.emilg1101.marketplace.model;

import com.github.emilg1101.marketplace.data.entity.Product;
import com.github.emilg1101.marketplace.data.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {
    long productId;
    String productImageURL;
    String productTitle;
    double productPrice;
    List<AddressItemModel> addresses;

    public static OrderModel map(Product product, User user) {
        return OrderModel.builder()
                .productId(product.getId())
                .productImageURL(product.getImageURL())
                .productTitle(product.getTitle())
                .productPrice(product.getPrice())
                .addresses(user.getAddresses().stream().map(AddressItemModel::map).collect(Collectors.toList()))
                .build();
    }
}
