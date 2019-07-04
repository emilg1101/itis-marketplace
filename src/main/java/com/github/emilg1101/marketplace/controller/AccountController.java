package com.github.emilg1101.marketplace.controller;

import com.github.emilg1101.marketplace.data.entity.User;
import com.github.emilg1101.marketplace.model.account.AccountModel;
import com.github.emilg1101.marketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/account")
    public String account(@RequestParam(required = false, name = "tab") String tab, ModelMap modelMap, UsernamePasswordAuthenticationToken principal) {
        User user = userService.get(((User) principal.getPrincipal()).getId());
        modelMap.addAttribute("model", AccountModel.map(user));
        modelMap.addAttribute("tab", tab == null ? "orders" : tab);
        return "account";
    }
}
