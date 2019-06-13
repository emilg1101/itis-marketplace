package com.github.emilg1101.marketplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "signup";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "signin";
    }
}
