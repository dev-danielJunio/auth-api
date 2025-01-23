package com.example.login_CRUD.model.repository;

import com.example.login_CRUD.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
