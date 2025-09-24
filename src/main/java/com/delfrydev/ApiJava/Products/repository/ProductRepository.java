package com.delfrydev.ApiJava.Products.repository;

import com.delfrydev.ApiJava.Products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> { }