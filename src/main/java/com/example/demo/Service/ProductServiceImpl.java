package com.example.demo.Service;

import com.example.demo.DB.data.Basket;
import com.example.demo.DB.data.User;
import com.example.demo.DTO.ProductDTO;
import com.example.demo.Mappers.ProductMapper;
import com.example.demo.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    private final ProductMapper mapper = ProductMapper.MAPPER;
    private final UserService userService;
    private final BasketService basketService;
    private final ProductRepo productRepo;


    @Autowired
    public ProductServiceImpl(UserService userService, BasketService basketService, ProductRepo productRepo) {
        this.userService = userService;
        this.basketService = basketService;
        this.productRepo = productRepo;
    }

    @Override
    public List<ProductDTO> getAll() {
        return mapper.fromProductList(productRepo.findAll());
    }

    @Override
    @Transactional
    public void addToUserBasket(Long productId, String username) {
        User user = userService.findByName(username);
        if (user == null){
            throw  new RuntimeException("user is Empty");
        }
        Basket basket = user.getBasket();
        if (basket == null){
            Basket newBasket = basketService.createBasket(user, Collections.singletonList(productId));
            user.setBasket(newBasket);
            userService.save(user);
        }
    }


}
