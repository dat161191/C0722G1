package reponsitory;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void add(Product product);

    Product findByID(int id);

    void update(int id,Product product);

    void remove(int id);
}
