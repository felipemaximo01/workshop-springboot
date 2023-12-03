package com.maximodev.springproduto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maximodev.springproduto.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    
}