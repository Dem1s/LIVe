package com.example.demo.controllers;

import com.example.demo.DTO.ProductDTO;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private  final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public String main(Model model){
        List<ProductDTO> list = productService.getAll();
        model.addAttribute("productList", list);
        return "product";
    }
    @GetMapping("/{id}/basket")
    public String AddToBasket(@PathVariable Long id, Principal principal){
        if(principal== null){
            return "redirect:/product";
        }
        productService.addToUserBasket(id, principal.getName());
        return "redirect:/product";
    }
}
