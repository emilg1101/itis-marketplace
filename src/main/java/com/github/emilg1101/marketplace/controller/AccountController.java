package com.github.emilg1101.marketplace.controller;

import com.github.emilg1101.marketplace.model.account.AccountModel;
import com.github.emilg1101.marketplace.model.AddressItemModel;
import com.github.emilg1101.marketplace.model.account.OrderItemModel;
import com.github.emilg1101.marketplace.model.account.ReviewItemModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AccountController {

    @GetMapping(path = "/account")
    public String account(ModelMap modelMap) {
        Date dNow = new Date();
        SimpleDateFormat ft =
                new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        List<OrderItemModel> orders = new ArrayList<>();
        orders.add(new OrderItemModel(1, "Closed", ft.format(dNow), 99.99, 1, "http://placehold.it/700x400", 10, "Title 1", 11.11));
        orders.add(new OrderItemModel(2, "Closed", ft.format(dNow), 99.99, 1, "http://placehold.it/700x400", 10, "Title 1", 11.11));
        orders.add(new OrderItemModel(3, "Closed", ft.format(dNow), 99.99, 1, "http://placehold.it/700x400", 10, "Title 1", 11.11));
        orders.add(new OrderItemModel(4, "Closed", ft.format(dNow), 99.99, 1, "http://placehold.it/700x400", 10, "Title 1", 11.11));
        orders.add(new OrderItemModel(5, "Closed", ft.format(dNow), 99.99, 1, "http://placehold.it/700x400", 10, "Title 1", 11.11));
        orders.add(new OrderItemModel(6, "Closed", ft.format(dNow), 99.99, 1, "http://placehold.it/700x400", 10, "Title 1", 11.11));
        orders.add(new OrderItemModel(7, "Closed", ft.format(dNow), 99.99, 1, "http://placehold.it/700x400", 10, "Title 1", 11.11));
        orders.add(new OrderItemModel(8, "Closed", ft.format(dNow), 99.99, 1, "http://placehold.it/700x400", 10, "Title 1", 11.11));
        orders.add(new OrderItemModel(9, "Closed", ft.format(dNow), 99.99, 1, "http://placehold.it/700x400", 10, "Title 1", 11.11));
        orders.add(new OrderItemModel(10, "Closed", ft.format(dNow), 99.99, 1, "http://placehold.it/700x400", 10, "Title 1", 11.11));

        List<ReviewItemModel> reviews = new ArrayList<>();
        reviews.add(new ReviewItemModel(1, "Sint sit mollit irure quis est nostrud cillum consequat Lorem esse do quis dolor esse\n" +
                "                                fugiat\n" +
                "                                sunt do. Eu ex commodo veniam Lorem aliquip laborum occaecat qui Lorem esse mollit\n" +
                "                                dolore", ft.format(dNow), 1, "http://placehold.it/700x400", "Title 1"));
        reviews.add(new ReviewItemModel(1, "Sint sit mollit irure quis est nostrud cillum consequat Lorem esse do quis dolor esse\n" +
                "                                fugiat\n" +
                "                                sunt do. Eu ex commodo veniam Lorem aliquip laborum occaecat qui Lorem esse mollit\n" +
                "                                dolore", ft.format(dNow), 1, "http://placehold.it/700x400", "Title 1"));
        reviews.add(new ReviewItemModel(1, "Sint sit mollit irure quis est nostrud cillum consequat Lorem esse do quis dolor esse\n" +
                "                                fugiat\n" +
                "                                sunt do. Eu ex commodo veniam Lorem aliquip laborum occaecat qui Lorem esse mollit\n" +
                "                                dolore", ft.format(dNow), 1, "http://placehold.it/700x400", "Title 1"));
        reviews.add(new ReviewItemModel(1, "Sint sit mollit irure quis est nostrud cillum consequat Lorem esse do quis dolor esse\n" +
                "                                fugiat\n" +
                "                                sunt do. Eu ex commodo veniam Lorem aliquip laborum occaecat qui Lorem esse mollit\n" +
                "                                dolore", ft.format(dNow), 1, "http://placehold.it/700x400", "Title 1"));
        reviews.add(new ReviewItemModel(1, "Sint sit mollit irure quis est nostrud cillum consequat Lorem esse do quis dolor esse\n" +
                "                                fugiat\n" +
                "                                sunt do. Eu ex commodo veniam Lorem aliquip laborum occaecat qui Lorem esse mollit\n" +
                "                                dolore", ft.format(dNow), 1, "http://placehold.it/700x400", "Title 1"));
        reviews.add(new ReviewItemModel(1, "Sint sit mollit irure quis est nostrud cillum consequat Lorem esse do quis dolor esse\n" +
                "                                fugiat\n" +
                "                                sunt do. Eu ex commodo veniam Lorem aliquip laborum occaecat qui Lorem esse mollit\n" +
                "                                dolore", ft.format(dNow), 1, "http://placehold.it/700x400", "Title 1"));
        reviews.add(new ReviewItemModel(1, "Sint sit mollit irure quis est nostrud cillum consequat Lorem esse do quis dolor esse\n" +
                "                                fugiat\n" +
                "                                sunt do. Eu ex commodo veniam Lorem aliquip laborum occaecat qui Lorem esse mollit\n" +
                "                                dolore", ft.format(dNow), 1, "http://placehold.it/700x400", "Title 1"));

        List<AddressItemModel> addresses = new ArrayList<>();
        addresses.add(new AddressItemModel(1, "Gafiyatullin Emil Rafaelevich", "Russian Federation", "Lenin street 1", "13", "Tatarstan", "Almetyevsk", "423455", "+7 917 936 xx 77"));

        AccountModel model = new AccountModel("username", "email@email.com", ft.format(dNow), orders, reviews, addresses);
        modelMap.addAttribute("model", model);
        return "account";
    }
}
