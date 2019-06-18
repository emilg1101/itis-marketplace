package com.github.emilg1101.marketplace.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AccountModel {
    String username;
    String email;
    List<OrderItemModel> orders;
}
