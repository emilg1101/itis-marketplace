package com.github.emilg1101.marketplace.controller;

import com.github.emilg1101.marketplace.model.AddressItemModel;
import com.github.emilg1101.marketplace.model.OrderModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    @GetMapping(path = "/order")
    public String order(@RequestParam("product_id") long productId, ModelMap modelMap) {
        List<AddressItemModel> addresses = new ArrayList<>();
        addresses.add(new AddressItemModel(1, "Gafiyatullin Emil Rafaelevich", "Russian Federation", "Lenin street 1", "13", "Tatarstan", "Almetyevsk", "423455", "+7 917 936 xx 77"));

        OrderModel model = new OrderModel(1, "http://placehold.it/700x400","Title 1", 11.11, addresses);
        modelMap.addAttribute("model", model);
        System.out.println(productId);
        return "order";
    }
}
