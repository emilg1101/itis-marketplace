package com.github.emilg1101.marketplace.model.account;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AccountModel {
    String username;
    String email;
    String registeredAt;
    List<OrderItemModel> orders;
    List<ReviewItemModel> reviews;
    List<AddressItemModel> addresses;
}
