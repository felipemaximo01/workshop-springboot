package com.maximodev.springproduto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maximodev.springproduto.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

    
}