package reponsitory.impl;

import model.Product;
import reponsitory.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product("Coca", 10000));
        productList.add(new Product("Pepsi", 10000));
        productList.add(new Product("Sting", 10000));
    }

    @Override
    public List<Product> findAll() {
    //dùng để kết nối DB lấy dữ liệu
        return productList;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }
}
