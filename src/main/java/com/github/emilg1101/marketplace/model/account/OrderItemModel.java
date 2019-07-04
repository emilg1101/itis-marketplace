package com.github.emilg1101.marketplace.model.account;

import com.github.emilg1101.marketplace.data.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemModel {
    long id;
    String status;
    String orderTime;
    String amount;
    long productId;
    String productImageURL;
    int productQuantity;
    String productTitle;
    double productPrice;

    public static OrderItemModel map(Order order) {
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        return OrderItemModel.builder()
                .id(order.getId())
                .status(order.getStatus())
                .orderTime(ft.format(order.getOrderTime()))
                .amount(String.format("%.2f", order.getTotal()))
                .productId(order.getProduct().getId())
                .productImageURL(order.getProduct().getImageURL())
                .productQuantity(order.getQuantity())
                .productTitle(order.getProduct().getTitle())
                .productPrice(order.getProduct().getPrice())
                .build();
    }
}
