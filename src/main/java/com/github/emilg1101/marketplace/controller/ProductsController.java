package com.github.emilg1101.marketplace.controller;

import com.github.emilg1101.marketplace.model.HomepageModel;
import com.github.emilg1101.marketplace.model.ProductItemModel;
import com.github.emilg1101.marketplace.model.ProductModel;
import com.github.emilg1101.marketplace.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/")
    public String products(ModelMap modelMap, UsernamePasswordAuthenticationToken principal) {
        HomepageModel homepageModel = HomepageModel.map(productService.getProducts());
        homepageModel.setLoggedIn(principal != null);
        modelMap.addAttribute("model", homepageModel);
        return "index";
    }

    @GetMapping(path = "/product")
    public String product(@RequestParam("id") long productId, ModelMap modelMap, UsernamePasswordAuthenticationToken principal) {
        ProductModel model = ProductModel.map(productService.getProduct(productId));
        model.setLoggedIn(principal != null);
        modelMap.addAttribute("model", model);
        return "product";
    }
}
