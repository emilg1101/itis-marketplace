package com.github.emilg1101.marketplace.model;

import com.github.emilg1101.marketplace.data.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HomepageModel {
    boolean loggedIn;
    List<ProductItemModel> products;

    public static HomepageModel map(List<Product> products) {
        return HomepageModel.builder()
                .products(products.stream().map(ProductItemModel::map).collect(Collectors.toList()))
                .build();
    }
}
