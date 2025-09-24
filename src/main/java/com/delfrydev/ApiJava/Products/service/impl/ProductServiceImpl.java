package com.delfrydev.ApiJava.Products.service.impl;

import com.delfrydev.ApiJava.Products.dtos.request.ProductRequest;
import com.delfrydev.ApiJava.Products.dtos.response.ProductResponse;
import com.delfrydev.ApiJava.Products.entity.Product;
import com.delfrydev.ApiJava.Products.repository.ProductRepository;
import com.delfrydev.ApiJava.Products.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductResponse> getAll() {
        return productRepository.findAll()
                .stream()
                    .map(p -> new ProductResponse(
                            p.getIdProduct(),
                            p.getNombre(),
                            p.getPrecio()))
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse getById(Long id) {
        return productRepository.findById(id)
                .map(p-> new ProductResponse(
                        p.getIdProduct(),
                        p.getNombre(),
                        p.getPrecio())
                ).orElse(null);
    }

    @Override
    public ProductResponse create(ProductRequest request) {
        var producto = new Product();
        producto.setNombre(request.getNombre());
        producto.setPrecio(request.getPrecio());
        var guardado = productRepository.save(producto);
        return new ProductResponse(guardado.getIdProduct(), guardado.getNombre(), guardado.getPrecio());
    }

    @Override
    public ProductResponse update(Long id, ProductRequest request) {
        var product = productRepository.findById(id).orElseThrow();
        product.setNombre(request.getNombre());
        product.setPrecio(request.getPrecio());
        var guardado = productRepository.save(product);
        return new ProductResponse(guardado.getIdProduct(), guardado.getNombre(), guardado.getPrecio());
    }

    @Override
    public void delete(Long id) {
        var product = productRepository.findById(id).orElseThrow();
        if(product.getIdProduct() > 0) {
            productRepository.deleteById(product.getIdProduct());
        }
    }
}
