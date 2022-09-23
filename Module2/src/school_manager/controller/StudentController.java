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
            System.out.println("4. Tìm kiếm theo tên hoặc mã sinh viên");
            System.out.println("5. Quay lại chương trình quản lý CodeGym");
            System.out.println("6. Sắp xếp theo tên,nếu giống nhau xếp theo mã");
            System.out.println("7. Thoát chương trình");
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
                    menuSearchStudent();
                    break;
                case 5:
                    Controller.manageMenuCodeGym();
                    break;
                case 6:
                    iStudentService.sortStudy();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Bạn nhập sai rồi!Vui lòng nhập lại");
            }
        }
    }

    private static void menuSearchStudent() {
        loop:
        while (true) {
            System.out.println("Mời bạn lựa chọn tìm kiếm");
            System.out.println("1.Tìm theo tên");
            System.out.println("2.Tìm theo mã sinh viên");
            System.out.println("3.Thoát");
            int choice1 = Integer.parseInt(scanner.nextLine());
            switch (choice1) {
                case 1:
                    iStudentService.findStudyName();
                    break;
                case 2:
                    iStudentService.findStudyCode();
                    break;
                case 3:
                    break loop;
                default:
            }

        }
    }
}
