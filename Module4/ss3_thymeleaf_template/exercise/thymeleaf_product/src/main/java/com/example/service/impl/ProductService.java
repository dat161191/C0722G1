package com.example.service.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public boolean addProduct(Product product) {
        return iProductRepository.addProduct(product);
    }

    @Override
    public boolean updateProduct(Product product) {
        return iProductRepository.updateProduct(product);
    }

    @Override
    public boolean removeProduct(int id) {
        return iProductRepository.removeProduct(id);
    }

    @Override
    public Product findProductById(int id) {
        return iProductRepository.findProductById(id);
    }

    @Override
    public Map<Integer, Product> searchByName(String name) {
        return iProductRepository.searchByName(name);
    }
}
