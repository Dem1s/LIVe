package com.example.demo.Service;

import com.example.demo.DTO.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAll();
    void addToUserBasket(Long productId, String username);
}
