package com.maximodev.springproduto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maximodev.springproduto.entities.User;
import com.maximodev.springproduto.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> objUser = userRepository.findById(id);
        return objUser.get();
    }

    public User insert(User objUser){
        return userRepository.save(objUser);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
