package ss17_io_binary_file_and_serialization.exercise.manage_product.service.impl;

import ss17_io_binary_file_and_serialization.exercise.manage_product.model.Product;
import ss17_io_binary_file_and_serialization.exercise.manage_product.service.IProductService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProducSerivce implements IProductService {
    private Scanner scanner = new Scanner(System.in);
    private List<Product> productList = new ArrayList<>();

    public void writeFile(List<Product> productList) {
        try {
            FileOutputStream outPut = new FileOutputStream("src/ss17_io_binary_file_and_serialization/exercise/manage_product/data/product.csv");
            ObjectOutputStream objectOutput = new ObjectOutputStream(outPut);
            objectOutput.writeObject(productList);
            objectOutput.close();
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }

    public List<Product> readFile() {
        List<Product> productList = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("src/ss17_io_binary_file_and_serialization/exercise/manage_product/data/product.csv");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            productList = new ArrayList<>();
            productList = (List<Product>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public void addProduct() {

        if (readFile() != null) {
            productList = readFile();
        }
        Product product = getInFoProduct();
        productList.add(product);
        writeFile(productList);
    }

    @Override
    public void display() {
        productList = readFile();
        for (Product i : productList) {
            System.out.println(i);
        }
    }

    @Override
    public void searchProduct() {
        productList = readFile();
        System.out.println("Nhập mã sản phẩm muốn tìm");
        String code = scanner.nextLine();
        boolean flag = false;
        for (Product product : productList) {
            if (product.getCodeProduct().contains(code)) {
                System.out.println(product);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Không tìm thấy đối tượng cần tìm");
        }

    }

    public Product getInFoProduct() {
        System.out.println("Mời bạn nhập mã sản phẩm");
        String code = scanner.nextLine();
        System.out.println("Mời bạ nhập tên sản phẩm");
        String name = scanner.nextLine();
        System.out.println("Mời bạn nhập hãng SX");
        String fabricator = scanner.nextLine();
        System.out.println("Mời bạn nhập giá tiền");
        Double price = Double.parseDouble(scanner.nextLine());
        return new Product(code, name, fabricator, price);
    }
}
