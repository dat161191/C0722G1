package ss17_io_binary_file_and_serialization.exercise.manage_product.controller;

import ss17_io_binary_file_and_serialization.exercise.manage_product.service.IProductService;
import ss17_io_binary_file_and_serialization.exercise.manage_product.service.impl.ProducSerivce;

import java.util.Scanner;

public class ProductController {
    private final IProductService productService = new ProducSerivce();
    private Scanner scanner = new Scanner(System.in);

    public void ControllerMeNu() {
        while (true) {
            System.out.println("-------------------------MENU----------------------------------");
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Tìm kiếm theo tên mã");
            System.out.println("4. Thoát chương trình");
            System.out.println("Mời bạn nhập lựa chọn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productService.addProduct();
                    break;
                case 2:
                    productService.display();
                    break;
                case 3:
                    productService.searchProduct();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Bạn đã nhập sai");
                    break;
            }
        }
    }
}
