package com.example.login_CRUD.controller;

import com.example.login_CRUD.model.entities.Product;
import com.example.login_CRUD.model.repository.ProductRepository;
import com.example.login_CRUD.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping()
    public ResponseEntity<Product> postProduct(@RequestBody Product product){
        Product creatProduct = productService.creatProduct(product);
        return ResponseEntity.ok(creatProduct);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> products = productService.getAllProduct();
        return ResponseEntity.ok(products);

    }
}
