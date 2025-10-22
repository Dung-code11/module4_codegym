package com.example.productmanagement.service;

import com.example.productmanagement.model.Product;
import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);
    void save(Product product);
    void update(Long id, Product product);
    void remove(Long id);
    List<Product> searchByName(String name);
}
