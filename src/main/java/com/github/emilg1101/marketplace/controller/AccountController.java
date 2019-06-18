package com.github.emilg1101.marketplace.controller;

import com.github.emilg1101.marketplace.model.AccountModel;
import com.github.emilg1101.marketplace.model.OrderItemModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AccountController {

    @GetMapping(path = "/account")
    public String account(ModelMap modelMap) {
        Date dNow = new Date( );
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
        AccountModel model = new AccountModel("username", "email@email.com", orders);
        modelMap.addAttribute("model", model);
        return "account";
    }
}
