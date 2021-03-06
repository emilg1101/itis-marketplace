package com.github.emilg1101.marketplace.model;

import com.github.emilg1101.marketplace.data.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductItemModel {
    long id;
    String imageURL;
    String title;
    String description;
    double price;

    public static ProductItemModel map(Product product) {
        return ProductItemModel.builder()
                .id(product.getId())
                .imageURL(product.getImageURL())
                .title(product.getTitle())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
