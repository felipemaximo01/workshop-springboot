package com.maximodev.springproduto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maximodev.springproduto.entities.Product;
import com.maximodev.springproduto.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService productsService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> listProducts = productsService.findAll();
        return ResponseEntity.ok().body(listProducts);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product objProduct = productsService.findById(id);
        return ResponseEntity.ok().body(objProduct);
    }
}
