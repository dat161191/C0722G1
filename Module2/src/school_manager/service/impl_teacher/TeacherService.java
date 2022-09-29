package school_manager.service.impl_teacher;

import school_manager.model.Student;
import school_manager.model.Teacher;
import school_manager.service.ISTeacherService;
import school_manager.service.util.NameException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ISTeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Teacher> teacherList = new ArrayList<>();

    @Override
    public void addTeacher() {
//        Teacher teacher = infoTeacher();
//        teacherList.add(teacher);
//        System.out.println("Thêm mới thành công");
        teacherList = getTeacherFile();
        System.out.println("Thêm mới thành công");
    }
    private void writeFile(List<Teacher> teacherList) {
        try {
            File file = new File("src/school_manager/data/student.csv");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Teacher i : teacherList) {
                bufferedWriter.write(i.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Teacher> getTeacherFile() {
        try {
            File file = new File("src/school_manager/data/teacher.csv");
            if (!file.exists()) {
                throw new Exception();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            teacherList = new ArrayList<>();
            String line;
            String[] info;
            Teacher teacher;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                teacher = new Teacher(info[0], info[1], info[2], info[3], info[4]);
                teacherList.add(teacher);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teacherList;
    }

    @Override
    public void displayTeacher() {
        teacherList = getTeacherFile();
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    @Override
    public void removeTeacher() {
        System.out.print("Mời bạn nhập mã Giáo Viên cần xóa: ");
        String code = scanner.nextLine();
        boolean flagDelete = false;
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getCode().equals(code)) {
                System.out.println("Bạn có chác muốn xóa Giáo Viên này không?" +
                        "Nhập Y:xóa ,N:không ");
                String choice = scanner.nextLine();
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
        String name = scanner.nextLine();
        boolean flag = false;
        for (Teacher teacher : teacherList) {
            if (teacher.getName().contains(name)) {
                System.out.println(teacher);
                flag = true;
            }

        }
        if (!flag) {
            System.out.println("Không tìm thấy đối tượng cần tìm");
        }
    }

    @Override
    public void findTeacherCode() {
        System.out.println("Nhập code muốn tìm");
        String code = scanner.nextLine();
        boolean flag = false;
        for (Teacher teacher : teacherList) {
            if (teacher.getCode().contains(code)) {
                System.out.println(teacher);
                flag = true;
            }

        }
        if (!flag) {
            System.out.println("Không tìm thấy đối tượng cần tìm");
        }

    }

    @Override
    public void sortTeacher() {
        for (int i = 0; i < teacherList.size() - 1; i++) {
            Teacher currentMin = teacherList.get(i);
            int currentMinIndex = i;
            for (int j = i + 1; j < teacherList.size(); j++) {
                if (currentMin.getName().compareTo(teacherList.get(j).getName()) > 0) {
                    currentMin = teacherList.get(j);
                    currentMinIndex = j;
                }
                if (currentMin.getName().compareTo(teacherList.get(j).getName()) == 0) {
                    int compare = currentMin.getCode().compareTo(teacherList.get(j).getCode());
                    if (compare > 0) {
                        currentMin = teacherList.get(j);
                        currentMinIndex = j;
                    }
                }

            }
            if (currentMinIndex != i) {
                teacherList.set(currentMinIndex, teacherList.get(i));
                teacherList.set(i, currentMin);
            }
        }
    }

    public Teacher infoTeacher() {
        System.out.print("Mời bạn nhập mã Giáo Viên: ");
        String code = scanner.nextLine();
        String name;
        while (true) {
            try {
                System.out.print("Mời bạn nhập tên Giáo Viên: ");
                name = scanner.nextLine();
                checkName(name);
                break;
            } catch (NameException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.print("Mời bạn nhập giới tính Giáo Viên: ");
        String tempGender = scanner.nextLine();
        String gender;
        if (tempGender.equals("Nam")) {
            gender = "Nam";
        } else if (tempGender.equals("Nữ")) {
            gender = "Nữ";
        } else {
            gender = "Giới tính thứ 3";
        }
        System.out.print("Mời bạn nhập chuyên môn Giáo Viên: ");
        String technique = scanner.nextLine();
        System.out.println("Mời bạn nhập ngày sinh Giáo Viên:");
        String birth = scanner.nextLine();

        return new Teacher(code, name, gender, birth, technique);
    }

    public void testTeacherList() {
        teacherList.add(new Teacher("5", "Thành", "1", "10/9/1982", "Toán"));
        teacherList.add(new Teacher("1", "Thành", "1", "26/9/1982", "Lý"));
        teacherList.add(new Teacher("2", "Đức", "1", "10/9/1982", "Thể Dục"));
        teacherList.add(new Teacher("4", "Hà", "2", "10/9/1989", "Hóa"));
        teacherList.add(new Teacher("3", "Hà", "2", "10/9/1988", "Lý"));
        System.out.println("thêm mới thành công");
    }

    public static void checkName(String str) throws NameException {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(0) == 32 || str.charAt(i) < 32 || str.charAt(i) > 32 && str.charAt(i) < 65 || str.charAt(i) > 90
                    && str.charAt(i) < 97 || str.charAt(i) > 122) {
                throw new NameException("Chuỗi này không đúng định dạng");
            }
        }
    }
}
