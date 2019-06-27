package com.github.emilg1101.marketplace.controller;

import com.github.emilg1101.marketplace.model.form.AddressForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AddressController {

    @GetMapping(path = "/address/add")
    public String add(ModelMap modelMap) {
        modelMap.addAttribute("action", "add");
        return "address";
    }

    @PostMapping(path = "/address/add")
    public String add(@Valid @ModelAttribute("addressForm") AddressForm form, BindingResult result, ModelMap modelMap) {
        modelMap.addAttribute("action", "add");
        if (result.hasErrors()) {
            modelMap.addAttribute("addressForm", form);
            modelMap.addAttribute("error", result.getFieldError().getDefaultMessage());
            return "address";
        }
        return "address";
    }

    @GetMapping(path = "/address/edit")
    public String edit(ModelMap modelMap) {
        modelMap.addAttribute("action", "edit");
        return "address";
    }

    @PostMapping(path = "/address/edit")
    public String edit(@Valid @ModelAttribute("addressForm") AddressForm form, BindingResult result, ModelMap modelMap) {
        modelMap.addAttribute("action", "edit");
        if (result.hasErrors()) {
            modelMap.addAttribute("addressForm", form);
            modelMap.addAttribute("error", result.getFieldError().getDefaultMessage());
            return "address";
        }
        return "address";
    }
}
