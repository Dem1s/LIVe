package com.example.demo.controllers;

import com.example.demo.DTO.ProductDTO;
import com.example.demo.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    private final ProductService productService;

    public MainController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String greeting(){
        return "greeting";
    }



    @GetMapping("/info")
    public String info(){
        return "info";
    }
}
