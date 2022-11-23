package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import com.example.service.IProductService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(1, "SUZUKI", 50000000d, "SU", "SUZUKI"));
        products.put(2, new Product(2, "AIRBLADE", 45000000d, "AB-DEN", "HONDA"));
        products.put(3, new Product(3, "Z-100", 450000000D, "Z-100", "YAMAHA"));
        products.put(4, new Product(4, "DUCATI-Hypermotard", 818888000d, "DES4", "VOLKSWAGEN"));

    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public boolean addProduct(Product product) {
        products.put(product.getId(), product);
        return true;
    }

    @Override
    public boolean updateProduct(Product product) {
        products.put(product.getId(), product);
        return true;
    }

    @Override
    public boolean removeProduct(int id) {
        products.remove(id);
        return true;
    }

    @Override
    public Product findProductById(int id) {
        return products.get(id);
    }

    @Override
    public Map<Integer, Product> searchByName(String name) {
        Map<Integer, Product> searchByName = new HashMap<Integer, Product>();
        for (Product product : products.values()) {
            if (product.getName().contains(name)) {
                searchByName.put(product.getId(), product);
            }
        }
        return searchByName;
    }
}
