package com.github.emilg1101.marketplace.controller;

import com.github.emilg1101.marketplace.data.entity.User;
import com.github.emilg1101.marketplace.model.form.ReviewForm;
import com.github.emilg1101.marketplace.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.validation.Valid;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping(path = "/review/add")
    public String add(@Valid @ModelAttribute("reviewForm") ReviewForm form, UsernamePasswordAuthenticationToken principal) {
        System.out.println(form.toString());
        reviewService.add(form, (User) principal.getPrincipal());
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("PC#product").arg(0, form.getProductId()).build();
    }

    @GetMapping(path = "/review/delete")
    public String delete(@RequestParam("id") long reviewId, UsernamePasswordAuthenticationToken principal) {
        reviewService.delete(reviewId, (User) principal.getPrincipal());
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("AC#account").arg(0, "reviews").build();
    }
}
