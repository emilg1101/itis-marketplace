package com.github.emilg1101.marketplace.model.account;

import com.github.emilg1101.marketplace.data.entity.User;
import com.github.emilg1101.marketplace.model.AddressItemModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountModel {
    String username;
    String email;
    String registeredAt;
    List<OrderItemModel> orders;
    List<ReviewItemModel> reviews;
    List<AddressItemModel> addresses;

    public static AccountModel map(User user) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd");
        AccountModel model = new AccountModel();
        model.username = user.getName();
        model.email = user.getEmail();
        model.registeredAt = ft.format(user.getRegDate());
        model.orders = new ArrayList<>();
        model.reviews = new ArrayList<>();
        model.addresses = user.getAddresses().stream().map(AddressItemModel::map).collect(Collectors.toList());
        return model;
    }
}
