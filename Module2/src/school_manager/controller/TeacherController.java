package school_manager.controller;

import school_manager.service.ISTeacherService;
import school_manager.service.impl_teacher.TeacherService;

import java.util.Scanner;

public class TeacherController {
    private static Scanner input = new Scanner(System.in);
    private static ISTeacherService isTeacherService = new TeacherService();

    public static void manageMenuTeacher() {
        while (true) {
            System.out.println("-------------------------------------\n" +
                    " Chào mừng bạn tới chương trình quản lý CodeGym\n"
                    + " 1.Thêm mới giáo viên\n"
                    + " 2.Hiển thị danh sách giáo viên\n"
                    + " 3.Xóa giáo viên\n"
                    + " 4.Tìm kiếm theo tên\n"
                    + " 5.Quay lại chương trình quản lý CodeGym\n"
                    + " 6.Thoát chương trình");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    isTeacherService.addTeacher();
                    break;
                case 2:
                    isTeacherService.displayTeacher();
                    break;
                case 3:
                    isTeacherService.removeTeacher();
                    break;
                case 4:
                    isTeacherService.findTeacherName();
                    break;
                case 5:
                    Controller.manageMenuCodeGym();
                    break;
                case 6:
                    System.exit(0);
                    return;
                default:
                    System.out.println("Bạn nhập sai rồi! Vui lòng nhập lại");
            }
        }
    }

}
