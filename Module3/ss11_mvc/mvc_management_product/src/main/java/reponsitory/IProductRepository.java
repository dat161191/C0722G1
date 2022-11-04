package reponsitory;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void add (Product product);
}
