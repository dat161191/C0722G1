package school_manager.controller;

import java.util.Scanner;

public class Controller {
    private static Scanner input = new Scanner(System.in);

    public static void manageMenuCodeGym() {
        System.out.println("Nhập lựa chon chương trình của bạn:\n"
                + " 1.Quản lý học sinh\n" + " 2.Quản lý Giáo viên\n"+" 3.Thoát chương trình");
        int choice = Integer.parseInt(input.nextLine());
        while (true) {
            switch (choice) {
                case 1:
                    StudentController.manageMenuStudent();
                    break;
                case 2:
                    TeacherController.manageMenuTeacher();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Bạn nhập sai rồi! Vui lòng Nhập lại");
            }

        }
    }
}
