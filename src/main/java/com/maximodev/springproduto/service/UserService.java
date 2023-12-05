package com.maximodev.springproduto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.maximodev.springproduto.entities.User;
import com.maximodev.springproduto.repositories.UserRepository;
import com.maximodev.springproduto.service.exceptions.DatabaseException;
import com.maximodev.springproduto.service.exceptions.ResouceNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> objUser = userRepository.findById(id);
        return objUser.orElseThrow(() -> new ResouceNotFoundException(id));
    }

    public User insert(User objUser) {
        return userRepository.save(objUser);
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResouceNotFoundException(id);
        } catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User objUser) {
        User entity = userRepository.getReferenceById(id);
        updateData(entity, objUser);
        return userRepository.save(entity);
    }

    private void updateData(User entity, User objUser) {
        entity.setName(objUser.getName());
        entity.setEmail(objUser.getEmail());
        entity.setPhone(objUser.getPhone());
    }
}
