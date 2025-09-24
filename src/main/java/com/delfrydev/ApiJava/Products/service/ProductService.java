package com.delfrydev.ApiJava.Products.service;

import com.delfrydev.ApiJava.Products.dtos.request.ProductRequest;
import com.delfrydev.ApiJava.Products.dtos.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAll();
    ProductResponse getById(Long id);
    ProductResponse create(ProductRequest request);
    ProductResponse update(Long id, ProductRequest request);
    void delete(Long id);
}
