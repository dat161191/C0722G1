package com.example.repository;

import com.example.model.Product;

import java.util.List;
import java.util.Map;

public interface IProductRepository {
    List<Product> findAll();

    void addProduct(Product product);

    void updateProduct(Product product);

    void removeProduct(Product product);

    Product findProductById(int id);

    List<Product> searchByName(String name);
}
