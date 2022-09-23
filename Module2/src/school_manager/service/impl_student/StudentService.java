package school_manager.service.impl_student;

import school_manager.model.Student;
import school_manager.service.IStudentService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> studentList = new ArrayList<>();

    @Override
    public void addStudent() {
        Student student = infoStudent();

        studentList.add(student);
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void displayAllStudent() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Override
    public void removeStudent() {
        System.out.print("Mời bạn nhập mã học sinh cần xóa: ");
        String code = scanner.nextLine();
        boolean flagDelete = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getCode().equals(code)) {
                System.out.println("Bạn có chắc muốn xóa học sinh này không? Nhập Y: yes, N: no");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    studentList.remove(i);
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
    public void findStudyName() {
        System.out.println("Nhập tên muốn tìm");
        String name = scanner.nextLine();
        boolean flag = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getName().contains(name)) {
                System.out.println(studentList.get(i));
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Không tìm thấy đối tượng cần tìm");
        }
    }

    @Override
    public void findStudyCode() {
        System.out.println("Nhập code muốn tìm");
        String code = scanner.nextLine();
        boolean flag = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getCode().equals(code)) {
                System.out.println(studentList.get(i));
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Không tìm thấy đối tượng cần tìm");
        }

    }

    @Override
    public void sortStudy() {
        for (int i = 0; i < studentList.size() - 1; i++) {
            Student currentMin = studentList.get(i);
            int currentMinIndex = i;
            for (int j = i + 1; j < studentList.size(); j++) {
                if (currentMin.getName().compareTo(studentList.get(j).getName()) > 0) {
                    currentMin = studentList.get(j);
                    currentMinIndex = j;
                }
                if (currentMin.getName().compareTo(studentList.get(j).getName()) == 0) {
                    int compare = currentMin.getCode().compareTo(studentList.get(j).getCode());
                    if (compare > 0) {
                        currentMin = studentList.get(j);
                        currentMinIndex = j;

                    }
                }

            }
            if (currentMinIndex != i) {
                studentList.set(currentMinIndex, studentList.get(i));
                studentList.set(i, currentMin);
            }
        }
    }


    public Student infoStudent() {
        System.out.print("Mời bạn nhập mã học sinh: ");
        String code = scanner.nextLine();
        System.out.print("Mời bạn nhập tên học sinh: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập giới tính học sinh: ");
        String tempGender = scanner.nextLine();
        String gender;
        if (tempGender.equals("1")) {
            gender = "Nam";
        } else if (tempGender.equals("2")) {
            gender = "Nữ";
        } else {
            gender = "Giới tính thứ 3";
        }
        System.out.print("Mời bạn nhập tên lớp: ");
        String nameClass = scanner.nextLine();
        System.out.print("Mời bạn nhập điểm của học sinh: ");
        double score = Double.parseDouble(scanner.nextLine());
        System.out.println("Mời bạn nhập ngày sinh Sinh Viên:");
        String birth = scanner.nextLine();
        return new Student(code, name, gender, birth, nameClass, score);
    }
}
