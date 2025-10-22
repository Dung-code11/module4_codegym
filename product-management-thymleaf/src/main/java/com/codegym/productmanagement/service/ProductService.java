package com.example.productmanagement.service;

import com.example.productmanagement.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product(1L, "Iphone 15", 1500, "New iPhone 15", "Apple"));
        products.add(new Product(2L, "Galaxy S23", 1200, "Samsung flagship", "Samsung"));
        products.add(new Product(3L, "Xiaomi 13", 800, "Affordable flagship", "Xiaomi"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public void update(Long id, Product product) {
        Product existing = findById(id);
        if (existing != null) {
            existing.setName(product.getName());
            existing.setPrice(product.getPrice());
            existing.setDescription(product.getDescription());
            existing.setManufacturer(product.getManufacturer());
        }
    }

    @Override
    public void remove(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    @Override
    public List<Product> searchByName(String name) {
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
}
