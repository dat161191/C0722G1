package school_manager.controller;

import school_manager.service.IPerson;
import school_manager.service.ISTeacherService;
import school_manager.service.IStudentService;
import school_manager.service.impl_student.StudentService;
import school_manager.service.impl_teacher.TeacherService;

import java.util.Scanner;

public class PersonController {
    private static final IStudentService iStudentService = new StudentService();
    private static final ISTeacherService isTeacherService = new TeacherService();
    private static final IPerson istudent=new StudentService();
    private static final IPerson iteacher=new TeacherService();
    static Scanner scanner = new Scanner(System.in);

    public static void personMenu() {
        while (true) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("Chào mừng bạn đến với chương trình quản lý CodeGym");
            System.out.println("1. Thêm mới học sinh hoặc giáo viên");
            System.out.println("2. Hiển thị danh sách học sinh hoặc giáo viên");
            System.out.println("3. Xóa học sinh hoặc giáo viên");
            System.out.println("4. Tìm kiếm theo tên hoặc mã sinh viên hoặc giáo viên");
            System.out.println("5. Sắp xếp theo tên,nếu giống nhau xếp theo mã");
            System.out.println("6. Thoát chương trình");
            System.out.println("Mời bạn nhập lựa chọn");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            switch (choice) {
                case 1:
                    PersonController.addMenu();
                    break;
                case 2:
                    PersonController.disPlayMeNu();
                    break;
                case 3:
                    PersonController.removeMeNu();
                    break;
                case 4:
                    PersonController.findMenu();
                    break;
                case 5:
                    PersonController.sortMeNu();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Bạn đã nhập sai!Vui lòng nhập lại");
            }
        }

    }

    public static void addMenu() {
        loop:
        while (true) {
            System.out.println("Mời bạn nhập lựa chọn");
            System.out.println("1.Thêm mới học sinh");
            System.out.println("2.Thêm mới giáo viên");
            System.out.println("3.Thoát");
            int choice1 = 0;
            try {
                choice1 = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            switch (choice1) {
                case 1:
                    iStudentService.addStudent();
                    break;
                case 2:
                    isTeacherService.addTeacher();
                    break;
                case 3:
                    break loop;
                default:
                    System.out.println("Bạn đã nhập sai vui lòng nhập lại");
            }
        }
    }

    public static void disPlayMeNu() {
        loop:
        while (true) {
            System.out.println("Mời bạn nhập lựa chọn");
            System.out.println("1.Hiển thị danh sách học sinh");
            System.out.println("2.Hiển thị danh sách giáo viên");
            System.out.println("3.Thoát");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            switch (choice) {
                case 1:
                    iStudentService.displayAllStudent();
                    break;
                case 2:
                    isTeacherService.displayTeacher();
                    break;
                case 3:
                    break loop;
                default:
                    System.out.println("Bạn đã nhập sai vui lòng nhập lại");
            }
        }
    }

    public static void removeMeNu() {
        loop:
        while (true) {
            System.out.println("Mời bạn nhập lựa chọn");
            System.out.println("1.Xóa học sinh");
            System.out.println("2.Xóa giáo viên");
            System.out.println("3.Thoát");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            switch (choice) {
                case 1:
                    iStudentService.removeStudent();
                    break;
                case 2:
                    isTeacherService.removeTeacher();
                    break;
                case 3:
                    break loop;
                default:
                    System.out.println("Bạn đã nhập sai vui lòng nhập lại");
            }
        }
    }

    public static void findMenu() {
        while (true) {
            System.out.println("Mời bạn nhập lựa chọn");
            System.out.println("1.Tìm học sinh");
            System.out.println("2.Tìm giáo viên");
            System.out.println("3.Thoát");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            switch (choice) {
                case 1:
//                    loop1:
//                    while (true) {
//                        System.out.println("Mời bạn lựa chọn tìm kiếm");
//                        System.out.println("1.Tìm theo tên");
//                        System.out.println("2.Tìm theo mã sinh viên");
//                        System.out.println("3.Thoát");
//                        int choice1 = 0;
//                        try {
//                            choice1 = Integer.parseInt(scanner.nextLine());
//                        } catch (NumberFormatException e) {
//                            e.printStackTrace();
//                        }
//                        switch (choice1) {
//                            case 1:
//                                iStudentService.findStudyName();
//                                break;
//                            case 2:
                                iStudentService.findStudyCode();
                                break;
//                            case 3:
//                                break loop1;
//                        }
//
//                    }
//                    break;
                case 2:
//                    loop2:
//                    while (true) {
//                        System.out.println("Mời bạn lựa chọn tìm kiếm");
//                        System.out.println("1.Tìm theo tên");
//                        System.out.println("2.Tìm theo mã giáo viên");
//                        System.out.println("3.Thoát");
//                        int choice1 = 0;
//                        try {
//                            choice1 = Integer.parseInt(scanner.nextLine());
//                        } catch (NumberFormatException e) {
//                            e.printStackTrace();
//                        }
//                        switch (choice1) {
//                            case 1:
//                                isTeacherService.findTeacherName();
//                                break;
//                            case 2:
                                isTeacherService.findTeacherCode();
                                break;
//                            case 3:
//                                break loop2;
//                            default:
//                                System.out.println("Bạn đã nhập sai vui lòng nhập lại");
//                        }
//                    }
//                    break;
                case 3:
                    return;
                default:
                    System.out.println("Bạn đã nhập sai vui lòng nhập lại");
            }
        }
    }

    public static void sortMeNu() {
        while (true) {
            System.out.println("Mời bạn nhập lựa chọn");
            System.out.println("1.Sắp xếp tăng dần theo tên học sinh,nếu tên trùng nhau sắp xếp tăng dần theo mã");
            System.out.println("2.Sắp xếp tăng dần theo tên giáo viên,nếu tên trùng nhau sắp xếp tăng dần theo mã");
            System.out.println("3.Thoát");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            switch (choice) {
                case 1:
                    iStudentService.sortStudy();
                    break;
                case 2:
                    isTeacherService.sortTeacher();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Bạn đã nhập sai vui lòng nhập lại");
            }
        }
    }

}
