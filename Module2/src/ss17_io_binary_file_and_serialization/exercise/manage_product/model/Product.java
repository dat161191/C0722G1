package ss17_io_binary_file_and_serialization.exercise.manage_product.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String codeProduct;
    private String productName;
    private String fabricator;
    private Double price;

    public Product(String codeProduct, String productName, String fabricator, Double price) {
        this.codeProduct = codeProduct;
        this.productName = productName;
        this.fabricator = fabricator;
        this.price = price;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getFabricator() {
        return fabricator;
    }

    public void setFabricator(String fabricator) {
        this.fabricator = fabricator;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s",this.getCodeProduct(),this.getProductName(),this.getFabricator(),this.getPrice());
    }
}
