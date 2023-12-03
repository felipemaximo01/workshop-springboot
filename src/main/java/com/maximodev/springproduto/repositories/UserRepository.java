package com.maximodev.springproduto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maximodev.springproduto.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
