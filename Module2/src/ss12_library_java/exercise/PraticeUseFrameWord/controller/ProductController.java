package ss12_library_java.exercise.PraticeUseFarmWord.controller;

import ss12_library_java.exercise.PraticeUseFarmWord.service.IProductManagerService;
import ss12_library_java.exercise.PraticeUseFrameWord.service.impl.ProductManagerService;

import java.util.Scanner;

public class ProductController {
    static Scanner scanner = new Scanner(System.in);
    static IProductManagerService product = new ProductManagerService();

    public static void menuProduct() {
        while (true) {
            System.out.println("Chào mừng bạn đến với chương trình quản lý sản phẩm");
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm theo ID");
            System.out.println("3. Xóa sản phẩm theo ID");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp danh sách giảm dần theo giá");
            System.out.println("7. Thoát chương trình");
            System.out.println("Mời bạn nhập lựa chon");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    product.addProduct();
                    break;
                case 2:
                    product.editProduct();
                    break;
                case 3:
                    product.removeProduct();
                    break;
                case 4:
                    product.displayProduct();
                    break;
                case 5:
                    product.findProduct();
                    break;
                case 6:
                    product.sortProduct();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Bạn nhập sai rồi!Vui lòng nhập lại");
            }
        }
    }
}


