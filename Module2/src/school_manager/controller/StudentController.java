package school_manager.controller;

import school_manager.service.IStudentService;
import school_manager.service.impl_student.StudentService;

import java.util.Scanner;

public class StudentController {//DI => module 4
    private static IStudentService iStudentService = new StudentService();
    private static Scanner scanner = new Scanner(System.in);

    public static void manageMenuStudent() {
        while (true) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("Chào mừng bạn đến với chương trình quản lý CodeGym");
            System.out.println("1. Thêm mới học sinh");
            System.out.println("2. Hiển thị danh sách học sinh");
            System.out.println("3. Xóa học sinh");
            System.out.println("4. Tìm kiếm theo tên");
            System.out.println("5. Quay lại chương trình quản lý CodeGym");
            System.out.println("6. Thoát chương trình");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    iStudentService.addStudent();
                    break;
                case 2:
                    iStudentService.displayAllStudent();
                    break;
                case 3:
                    iStudentService.removeStudent();
                    break;
                case 4:
                    iStudentService.findStudyName();
                    break;
                case 5:
                    Controller.manageMenuCodeGym();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Bạn nhập sai rồi!Vui lòng nhập lại");
            }
        }
    }
}
