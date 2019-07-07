package com.github.emilg1101.marketplace.rest.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.emilg1101.marketplace.data.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private Long id;
    private String title;
    private String description;
    @JsonProperty("image_url")
    private String imageURL;
    private Double price;

    public static ProductResponse map(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .title(product.getTitle())
                .description(product.getDescription())
                .imageURL(product.getImageURL())
                .price(product.getPrice())
                .build();
    }
}
