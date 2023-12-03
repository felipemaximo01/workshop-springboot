package com.maximodev.springproduto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maximodev.springproduto.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    
}