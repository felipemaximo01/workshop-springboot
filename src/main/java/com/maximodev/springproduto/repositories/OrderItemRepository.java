package com.maximodev.springproduto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maximodev.springproduto.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    
}
