package com.example.demo.Repository;

import com.example.demo.DB.data.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepo  extends JpaRepository<Basket, Long> {
}
