package school_manager.service.impl_teacher;

import school_manager.model.Teacher;
import school_manager.service.ISTeacherService;
import school_manager.service.util.PersonCheckException;
import school_manager.service.util.PersonException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ISTeacherService {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Teacher> teacherList = new ArrayList<>();

    @Override
    public void addTeacher() {
        teacherList = getTeacherFile();
        Teacher teacher = infoTeacher();
        teacherList.add(teacher);
        System.out.println("Thêm mới thành công");
        writeFile(teacherList);
    }

    private void writeFile(List<Teacher> teacherList) {
        try {
            File file = new File("src/school_manager/data/teacher.csv");
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
                try {
                    info = line.split(",");
                    teacher = new Teacher(info[0], info[1], info[2], info[3], info[4]);
                    teacherList.add(teacher);
                } catch (Exception ignored) {
                }
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
        teacherList = getTeacherFile();
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
        writeFile(teacherList);
    }

    @Override
    public void findTeacherName() {
        teacherList = getTeacherFile();
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
        teacherList = getTeacherFile();
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
        teacherList = getTeacherFile();
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
        writeFile(teacherList);
    }

    public Teacher infoTeacher() {
        String code;
        while (true) {
            try {
                System.out.print("Mời bạn nhập mã học sinh: ");
                code = scanner.nextLine();
                PersonCheckException.checkCode(code);
                break;
            } catch (PersonException e) {
                System.out.println(e.getMessage());
            }
        }
        String name;
        while (true) {
            try {
                System.out.print("Mời bạn nhập tên Giáo Viên: ");
                name = scanner.nextLine();
                PersonCheckException.checkName(name);
                break;
            } catch (PersonException e) {
                e.printStackTrace();
            }
        }
        String gender;
        while (true) {
            try {
                System.out.println("Mời bạn nhập giới tính Giáo Viên: ");
                System.out.println("Nhập 1 = Giới tính Nam ");
                System.out.println("Nhập 2 = Giới tính Nữ ");
                System.out.println("Nhập 3 = Giới tính Thứ 3 ");
                String tempGender = scanner.nextLine();
                PersonCheckException.checkGender(tempGender);
                if (tempGender.equals("1")) {
                    gender = "Nam";
                } else if (tempGender.equals("2")) {
                    gender = "Nữ";
                } else {
                    gender = "Giới tính thứ 3";
                }
                break;
            } catch (PersonException e) {
                System.out.println("Bạn đã nhập sai,vui lòng nhập lại!");
            }
        }
        String technique;
        while (true) {
            try {
                System.out.print("Mời bạn nhập chuyên môn Giáo Viên: ");
                technique = scanner.nextLine();
                PersonCheckException.checkTenique(technique);
                break;
            } catch (PersonException e) {
                System.out.println(e.getMessage());
            }
        }
        String birth;
        while (true) {
            try {
                System.out.println("Mời bạn nhập ngày tháng năm sinh theo định dạng dd/mm/yyyy");
                birth = scanner.nextLine();
                PersonCheckException.checkBirth(birth);
                break;
            } catch (PersonException e) {
                System.out.println(e.getMessage());
            }
        }


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


}
