package com.github.emilg1101.marketplace.controller;

import com.github.emilg1101.marketplace.data.entity.User;
import com.github.emilg1101.marketplace.exception.UserAlreadyExistsException;
import com.github.emilg1101.marketplace.exception.WrongEmailOrPasswordException;
import com.github.emilg1101.marketplace.model.form.RegistrationForm;
import com.github.emilg1101.marketplace.model.form.SigninForm;
import com.github.emilg1101.marketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/register")
    public String register() {
        return "signup";
    }

    @PostMapping(path = "/register")
    public String register(@Valid @ModelAttribute("registrationForm") RegistrationForm form, BindingResult result, ModelMap modelMap) {
        modelMap.addAttribute("registrationForm", form);
        if (result.hasErrors()) {
            modelMap.addAttribute("error", result.getFieldError().getDefaultMessage());
            return "signup";
        }
        try {
            userService.register(form);
        } catch (UserAlreadyExistsException e) {
            modelMap.addAttribute("error", "This e-mail already registered!");
            return "signup";
        }
        return "signup";
    }

    @GetMapping(path = "/login")
    public String login() {
        return "signin";
    }

    @PostMapping(path = "/login")
    public String login(@Valid @ModelAttribute("signinForm") SigninForm form, BindingResult result, ModelMap modelMap) {
        modelMap.addAttribute("signinForm", form);
        if (result.hasErrors()) {
            modelMap.addAttribute("error", result.getFieldError().getDefaultMessage());
            return "signin";
        }
        try {
            userService.login(form);
        } catch (WrongEmailOrPasswordException e) {
            modelMap.addAttribute("error", "E-mail or password incorrect!");
            return "signin";
        }

        return "index";
    }
}
