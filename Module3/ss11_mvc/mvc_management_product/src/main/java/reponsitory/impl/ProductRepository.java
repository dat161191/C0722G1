package reponsitory.impl;

import model.Product;
import reponsitory.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Coca", 10000));
        productList.add(new Product(2, "Pepsi", 10000));
        productList.add(new Product(3, "Sting", 10000));
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

    @Override
    public Product findByID(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==(id)) {
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==(id)) {
                productList.set(i, product);
            }
        }
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }


}
