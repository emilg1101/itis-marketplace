package com.github.emilg1101.marketplace.controller;

import com.github.emilg1101.marketplace.data.entity.Address;
import com.github.emilg1101.marketplace.data.entity.User;
import com.github.emilg1101.marketplace.model.form.AddressForm;
import com.github.emilg1101.marketplace.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.validation.Valid;

@Controller
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping(path = "/address/add")
    public String add(ModelMap modelMap) {
        modelMap.addAttribute("action", "add");
        return "address";
    }

    @PostMapping(path = "/address/add")
    public String add(@Valid @ModelAttribute("addressForm") AddressForm form, BindingResult result, ModelMap modelMap, UsernamePasswordAuthenticationToken principal) {
        modelMap.addAttribute("action", "add");
        if (result.hasErrors()) {
            modelMap.addAttribute("addressForm", form);
            modelMap.addAttribute("error", result.getFieldError().getDefaultMessage());
            return "address";
        }
        addressService.add(form, ((User) principal.getPrincipal()));
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("AC#account").arg(0, "address").build();
    }

    @GetMapping(path = "/address/edit")
    public String edit(@RequestParam("id") long addressId, UsernamePasswordAuthenticationToken principal, ModelMap modelMap) {
        Address address = addressService.get(addressId, (User) principal.getPrincipal());
        modelMap.addAttribute("addressForm", AddressForm.map(address));
        modelMap.addAttribute("action", "edit");
        return "address";
    }

    @PostMapping(path = "/address/edit")
    public String edit(@Valid @ModelAttribute("addressForm") AddressForm form, BindingResult result, ModelMap modelMap, UsernamePasswordAuthenticationToken principal) {
        modelMap.addAttribute("action", "edit");
        if (result.hasErrors()) {
            modelMap.addAttribute("addressForm", form);
            modelMap.addAttribute("error", result.getFieldError().getDefaultMessage());
            return "address";
        }
        addressService.update(form, (User) principal.getPrincipal());
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("AC#account").arg(0, "address").build();
    }

    @GetMapping(path = "/address/delete")
    public String delete(@RequestParam("id") long addressId, UsernamePasswordAuthenticationToken principal) {
        addressService.delete(addressId, (User) principal.getPrincipal());
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("AC#account").arg(0, "address").build();
    }
}
