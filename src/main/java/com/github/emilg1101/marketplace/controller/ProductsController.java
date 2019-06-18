package com.github.emilg1101.marketplace.controller;

import com.github.emilg1101.marketplace.model.HomepageModel;
import com.github.emilg1101.marketplace.model.ProductItemModel;
import com.github.emilg1101.marketplace.model.ProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductsController {

    @GetMapping(path = "/")
    public String products(ModelMap modelMap) {
        HomepageModel homepageModel = new HomepageModel();
        List<ProductItemModel> productItemModelList = new ArrayList<>();
        productItemModelList.add(new ProductItemModel(0L, "http://placehold.it/700x400", "title 1", "description 1", 99.99));
        productItemModelList.add(new ProductItemModel(1L, "http://placehold.it/700x400", "title 2", "description 2", 99.99));
        productItemModelList.add(new ProductItemModel(2L, "http://placehold.it/700x400", "title 3", "description 3", 99.99));
        productItemModelList.add(new ProductItemModel(3L, "http://placehold.it/700x400", "title 4", "description 4", 99.99));
        productItemModelList.add(new ProductItemModel(4L, "http://placehold.it/700x400", "title 5", "description 5", 99.99));
        productItemModelList.add(new ProductItemModel(5L, "http://placehold.it/700x400", "title 6", "description 6", 99.99));
        productItemModelList.add(new ProductItemModel(6L, "http://placehold.it/700x400", "title 7", "description 7", 99.99));
        productItemModelList.add(new ProductItemModel(7L, "http://placehold.it/700x400", "title 8", "description 8", 99.99));
        productItemModelList.add(new ProductItemModel(8L, "http://placehold.it/700x400", "title 9", "description 9", 99.99));
        productItemModelList.add(new ProductItemModel(9L, "http://placehold.it/700x400", "title 10", "description 10", 99.99));
        homepageModel.setProducts(productItemModelList);
        modelMap.addAttribute("model", homepageModel);
        return "index";
    }

    @GetMapping(path = "/product")
    public String product(ModelMap modelMap) {
        ProductModel productModel = new ProductModel(0L, "http://placehold.it/700x400", "title 1", "description 1", 99.99);
        modelMap.addAttribute("model", productModel);
        return "product";
    }
}
