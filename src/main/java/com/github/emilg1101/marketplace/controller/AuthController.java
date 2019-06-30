package com.github.emilg1101.marketplace.controller;

import com.github.emilg1101.marketplace.model.form.RegistrationForm;
import com.github.emilg1101.marketplace.model.form.SigninForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AuthController {

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
        if (form.getEmail().equals("emilyandro99@gmail.com") && form.getPassword().equals("qwerty")) {
            return "redirect:/";
        }
        modelMap.addAttribute("error", "E-mail or password incorrect!");
        return "signin";
    }

    @GetMapping(path = "/logout")
    public String logout() {
        return "redirect:/login";
    }
}
