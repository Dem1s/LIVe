package com.example.demo.Service;

import com.example.demo.DB.data.Basket;
import com.example.demo.DB.data.Product;
import com.example.demo.DB.data.User;
import com.example.demo.Repository.BasketRepo;
import com.example.demo.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BasketServiceImpl implements BasketService {
   private  final BasketRepo basketRepo;
   private final ProductRepo productRepo;

@Autowired
    public BasketServiceImpl(BasketRepo basketRepo, ProductRepo productRepo) {
        this.basketRepo = basketRepo;
        this.productRepo = productRepo;
    }

    @Override
    @Transactional
    public Basket createBasket(User user, List<Long> productId) {
    Basket basket = new Basket();
    basket.setUser(user);
    List<Product> productList = getCollectRefProdById(productId);
        return basketRepo.save(basket);
    }

    private List<Product> getCollectRefProdById(List<Long> productId) {
    return productId.stream()
            .map(productRepo::getById)
            .collect(Collectors.toList());
    }

    @Override
    public void addProduct(Basket basket, List<Long> productId) {
    List<Product> products = basket.getProducts();
    List<Product> newProductList = products == null ? new ArrayList<>() : new ArrayList<>(products);
    newProductList.addAll(getCollectRefProdById(productId));
    basketRepo.save(basket);
    }
}
