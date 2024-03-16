package com.nxm.palceup.controllers;

import com.nxm.palceup.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AdminController {
    private final ProductService productService;

    @GetMapping
    public String home() {
        return "redirect:/admin/main.html";
    }


}