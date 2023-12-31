package com.maximodev.springproduto.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.maximodev.springproduto.entities.User;
import com.maximodev.springproduto.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> listUsers = userService.findAll();
        return ResponseEntity.ok().body(listUsers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User objUser = userService.findById(id);
        return ResponseEntity.ok().body(objUser);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User objUser){
        objUser = userService.insert(objUser);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objUser.getId()).toUri();
        return ResponseEntity.created(uri).body(objUser);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User objUser) {
        objUser = userService.update(id, objUser);
        return ResponseEntity.ok().body(objUser);
    }
}
