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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/")
    public String products(ModelMap modelMap, UsernamePasswordAuthenticationToken principal) {
        HomepageModel homepageModel = new HomepageModel();
        homepageModel.setLoggedIn(principal != null);
        List<ProductItemModel> productItemModelList = productService.getProducts()
                .stream()
                .map(ProductItemModel::map)
                .collect(Collectors.toList());
        homepageModel.setProducts(productItemModelList);
        modelMap.addAttribute("model", homepageModel);
        return "index";
    }

    @GetMapping(path = "/product")
    public String product(ModelMap modelMap, UsernamePasswordAuthenticationToken principal) {
        ProductModel productModel = new ProductModel(principal != null, 0L, "http://placehold.it/700x400", "title 1", "description 1", 99.99);
        modelMap.addAttribute("model", productModel);
        return "product";
    }
}
