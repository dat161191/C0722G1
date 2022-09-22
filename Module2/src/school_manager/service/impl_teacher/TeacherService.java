package school_manager.service.impl_teacher;

import school_manager.model.Teacher;
import school_manager.service.ISTeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ISTeacherService {
    private static Scanner input = new Scanner(System.in);
    private static List<Teacher> teacherList = new ArrayList<>();

    @Override
    public void addTeacher() {
        Teacher teacher = infoTeacher();
        teacherList.add(teacher);
        System.out.println("Thêm mới thành công");

    }

    @Override
    public void displayTeacher() {
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    @Override
    public void removeTeacher() {
        System.out.print("Mời bạn nhập mã Giáo Viên cần xóa: ");
        String code = input.nextLine();
        boolean flagDelete = false;
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getCode().equals(code)) {
                System.out.println("Bạn có chác muốn xóa Giáo Viên này không?" +
                        "Nhập Y:xóa ,N:không ");
                String choice = input.nextLine();
                if (choice.equals("Y")) {
                    teacherList.remove(i);
                    System.out.println("Xóa thành công");
                }
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.out.println("Không tìm thấy đối tượng cần xóa.");
        }
    }

    @Override
    public void findTeacherName() {
        System.out.println("Nhập tên muốn tìm");
        String name = input.nextLine();
        boolean flag = false;
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getName().contains(name)) {
                System.out.println(teacherList.get(i));
                flag = true;
            }

        }
        if (flag == false) {
            System.out.println("Không tìm thấy đối tượng cần tìm");
        }
    }

    public Teacher infoTeacher() {
        System.out.print("Mời bạn nhập mã Giáo Viên: ");
        String code = input.nextLine();
        System.out.print("Mời bạn nhập tên Giáo Viên: ");
        String name = input.nextLine();
        System.out.print("Mời bạn nhập giới tính Giáo Viên: ");
        String tempGender = input.nextLine();
        String gender;
        if (tempGender.equals("Nam")) {
            gender = "Nam";
        } else if (tempGender.equals("Nữ")) {
            gender = "Nữ";
        } else {
            gender = "Giới tính thứ 3";
        }
        System.out.print("Mời bạn nhập chuyên môn Giáo Viên: ");
        String technique = input.nextLine();

        return new Teacher(code, name, gender, technique);
    }
}
