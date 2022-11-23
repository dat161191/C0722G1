package com.example.repository;

import com.example.model.Product;

import java.util.List;
import java.util.Map;

public interface IProductRepository {
    List<Product> findAll();

    boolean addProduct(Product product);

    boolean updateProduct(Product product);

    boolean removeProduct(int id);

    Product findProductById(int id);

    Map<Integer, Product> searchByName(String name);
}
