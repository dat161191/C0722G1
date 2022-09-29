package ss12_library_java.exercise.PraticeUseFrameWord.service.impl;

import ss12_library_java.exercise.PraticeUseFrameWord.model.Product;
import ss12_library_java.exercise.PraticeUseFarmWord.service.IProductManagerService;

import java.util.*;

public class ProductManagerService implements IProductManagerService, Comparator<Product> {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Product> productList = new ArrayList<>();

    public Product infoProduct() {
        System.out.print("Nhập tên sản phẩm:");
        String name = scanner.nextLine();
        System.out.print("Nhập ID sản phẩm: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập giá sản phẩm");
        Integer price = Integer.parseInt(scanner.nextLine());
        return new Product(name, id, price);
    }

    @Override
    public void addProduct() {
        Product product = infoProduct();
        productList.add(product);
        System.out.println("Thêm Mới Thành Công");
    }

    @Override
    public void editProduct() {
        System.out.println("Nhập ID muốn sửa");
        Integer id = Integer.parseInt(scanner.nextLine());
        boolean flag = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(id)) {
                while (true) {
                    System.out.println("1.Chọn sửa tên\n" + "2.Chọn sửa id\n" + "3.Quay lại Menu Sản Phẩm");
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.println("Nhập Tên mới");
                            String name1 = scanner.nextLine();
                            productList.get(i).setName(name1);
                            break;
                        case 2:
                            System.out.println("Nhập id mới:");
                            Integer id1 = Integer.parseInt(scanner.nextLine());
                            productList.get(i).setId(id1);
                            break;
                        case 3:
                            ss12_library_java.exercise.PraticeUseFarmWord.controller.ProductController.menuProduct();
                        default:
                            System.out.println("Bạn chọn sai vui lòng chọn lại");
                    }
                }

            }
            flag = true;

        }
        if (flag = false) {
            System.out.println("Không tìm thấy sản phẩm muốn sửa");
        }

    }

    @Override
    public void removeProduct() {
        System.out.println("Nhập ID muốn xóa");
        Integer id = Integer.parseInt(scanner.nextLine());
        boolean flag = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(id)) {
                System.out.println("Bạn có muốn xóa sản phẩm này không");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    productList.remove(i);
                    System.out.println("Xóa Thành công");
                }
                flag = true;
                break;
            }
        }
        if (flag = false) {
            System.out.println("Không tìm thấy sản phẩm muốn xóa");
        }
    }

    @Override
    public void findProduct() {
        boolean flagDelete = false;
        System.out.println("nhập tên sản phẩm cần tìm");
        String name = (scanner.nextLine());
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().contains(name)) {
                System.out.println(productList.get(i));
            }
            flagDelete = true;
        }
        if (!flagDelete) {
            System.out.println("Car: Không tìm thấy đối tượng cần tìm.");
        }

    }

    @Override
    public void displayProduct() {
        for (Product i : productList) {
            System.out.println(i);
        }

    }

    public void sortProduct() {
        ProductManagerService productSort = new ProductManagerService();
        Collections.sort(productList, productSort);
        System.out.println("Nếu giá bằng nhau thì sắp theo tên");
        for (Product i : productList) {
            System.out.println(i.toString());
        }
    }

    @Override

    public int compare(Product o1, Product o2) {
        int compare = Integer.compare(o1.getPrice(), o2.getPrice());
        if (compare != 0) {
            return compare;
        } else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}