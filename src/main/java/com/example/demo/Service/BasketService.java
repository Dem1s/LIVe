package com.example.demo.Service;

import com.example.demo.DB.data.Basket;
import com.example.demo.DB.data.User;

import java.util.List;

public interface BasketService {
    Basket createBasket(User user, List<Long> productId);

    void addProduct(Basket basket, List<Long> productId);
}
