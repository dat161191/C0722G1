package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void add(Product product);
    Product findByID(int id);

    void update(int id,Product product);

    void remove(int id);
}
