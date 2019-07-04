package com.github.emilg1101.marketplace.controller;

import com.github.emilg1101.marketplace.data.entity.Product;
import com.github.emilg1101.marketplace.data.entity.User;
import com.github.emilg1101.marketplace.model.OrderModel;
import com.github.emilg1101.marketplace.model.form.OrderForm;
import com.github.emilg1101.marketplace.service.OrderService;
import com.github.emilg1101.marketplace.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class OrderController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @GetMapping(path = "/order")
    public String order(@RequestParam("product_id") long productId, ModelMap modelMap, UsernamePasswordAuthenticationToken principal) {
        Product product = productService.getProduct(productId);
        modelMap.addAttribute("model", OrderModel.map(product, (User) principal.getPrincipal()));
        return "order";
    }

    @PostMapping(path = "/order")
    public String order(@Valid @ModelAttribute("orderForm") OrderForm form, BindingResult result, ModelMap modelMap, UsernamePasswordAuthenticationToken principal) {
        Product product = productService.getProduct(form.getProductId());
        modelMap.addAttribute("model", OrderModel.map(product, (User) principal.getPrincipal()));

        if (result.hasErrors()) {
            modelMap.addAttribute("orderForm", form);
            modelMap.addAttribute("error", result.getFieldError().getDefaultMessage());
            return "order";
        }

        orderService.order(form, (User) principal.getPrincipal());
        return "order";
    }

    @GetMapping(path = "/order/cancel")
    public String cancel(@RequestParam("id") long orderId, UsernamePasswordAuthenticationToken principal) {
        orderService.cancel(orderId, (User) principal.getPrincipal());
        return "redirect:/account?tab=orders";
    }
}
