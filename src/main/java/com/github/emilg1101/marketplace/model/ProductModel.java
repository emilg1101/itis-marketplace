package com.github.emilg1101.marketplace.model;

import com.github.emilg1101.marketplace.data.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductModel {
    boolean loggedIn;
    long id;
    String imageURL;
    String title;
    String description;
    double price;
    private List<ReviewItemModel> reviews;

    public static ProductModel map(Product product) {
        return ProductModel.builder()
                .id(product.getId())
                .imageURL(product.getImageURL())
                .title(product.getTitle())
                .description(product.getDescription())
                .price(product.getPrice())
                .reviews(product.getReviews().stream().map(ReviewItemModel::map).collect(Collectors.toList()))
                .build();
    }
}
