package school_manager.service.impl_teacher;

import school_manager.controller.PersonController;
import school_manager.model.Teacher;
import school_manager.service.ISTeacherService;
import school_manager.until.PersonCheckException;
import school_manager.until.PersonException;
import school_manager.until.SortNameTeacher;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class TeacherService implements ISTeacherService {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Teacher> teacherList = new ArrayList<>();
    private final DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    private void writeFile(List<Teacher> teacherList) {
        try {
            File file = new File("src/school_manager/data/teacher.csv");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Teacher i : teacherList) {
                bufferedWriter.write(getinfo(i));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Teacher> getTeacherFile() {
        File file = new File("src/school_manager/data/teacher.csv");
        if (!file.exists()) {
            System.out.println("File này không tồn tại");
        }
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            teacherList = new ArrayList<>();
            String line;
            String[] info;
            Teacher teacher;
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    info = line.split(",");
                    teacher = new Teacher(info[0], info[1], info[2], LocalDate.parse(info[3], fm), info[4]);
                    teacherList.add(teacher);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            assert bufferedReader != null;
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return teacherList;
    }

    @Override
    public void addTeacher() {
        teacherList = getTeacherFile();
        if (teacherList.size() == 0) {
            System.out.println("File này đang rỗng");
        }
        Teacher teacher = infoTeacher();
        teacherList.add(teacher);
        System.out.println("Thêm mới thành công");
        writeFile(teacherList);
    }

    @Override
    public void displayTeacher() {
        teacherList = getTeacherFile();
        if (teacherList.size() == 0) {
            System.out.println("File này đang rỗng không có danh sách hiển thị");
            PersonController.personMenu();
        }
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    @Override
    public void removeTeacher() {
        teacherList = getTeacherFile();
        if (teacherList.size() == 0) {
            System.out.println("File này đang rỗng không thể tìm");
            PersonController.personMenu();
        }
        String code;
        while (true) {
            try {
                System.out.println("Mời bạn nhập mã Giáo Viên muốn Xóa");
                code = scanner.nextLine();
                PersonCheckException.checkCode(code);
                break;
            } catch (PersonException e) {
                System.out.println(e.getMessage());
            }
        }
        boolean flagDelete = false;
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getCode().equals(code)) {
                System.out.println("Bạn có chác muốn xóa Giáo Viên này không?" +
                        "Nhập Y:xóa ,N:không ");
                String choice;
                while (true) {
                    try {
                        choice = scanner.nextLine();
                        PersonCheckException.checkYesNo(choice);
                        break;
                    } catch (PersonException e) {
                        System.out.println(e.getMessage());
                    }
                }
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
        if (teacherList.size() == 0) {
            System.out.println("File này đang rỗng không thể tìm kiếm");
            PersonController.personMenu();
        }
        String name;
        while (true) {
            try {
                System.out.println("Mời bạn nhập tên Giáo viêm cần tìm: ");
                name = scanner.nextLine();
                PersonCheckException.checkName(name);
                break;
            } catch (PersonException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Tên Này sai định dạng vui lòng nhập lại");
            }
        }
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
        if (teacherList.size() == 0) {
            System.out.println("File này đang rỗng không thể tìm kiếm");
            PersonController.personMenu();
        }
        String code;
        while (true) {
            try {
                System.out.println("Mời bạn nhập mã Giáo Viên muốn tìm");
                code = scanner.nextLine();
                PersonCheckException.checkCode(code);
                break;
            } catch (PersonException e) {
                System.out.println(e.getMessage());
            }
        }
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
        if (teacherList.size() == 0) {
            System.out.println("File này đang rỗng không thể sắp xếp");
            PersonController.personMenu();

        }
        teacherList.sort(new SortNameTeacher());
        teacherList.sort(new SortNameTeacher().reversed());
        writeFile(teacherList);
    }

    public Teacher infoTeacher() {
        String code;
        while (true) {
            try {
                System.out.println("Mời bạn nhập mã Giáo Viên: \n" + "Định dạng mã: 1 chữ cái in hoa đầu tiên + 2 số");
                code = scanner.nextLine();
                PersonCheckException.checkCode(code);
                PersonCheckException.checkDuplicatedCode(code, teacherList);
                break;
            } catch (PersonException e) {
                System.out.println(e.getMessage());
            }
        }
        String name;
        while (true) {
            try {
                System.out.println("Mời bạn nhập tên Giáo Viên: ");
                name = scanner.nextLine();
                PersonCheckException.checkName(name);
                break;
            } catch (PersonException e) {
                System.out.println(e.getMessage());
            }
        }
        String gender = "^:^";
        while (true) {
            try {
                System.out.println("Mời bạn nhập giới tính Giáo Viên: ");
                System.out.println("Nhập 1 = Giới tính Nam ");
                System.out.println("Nhập 2 = Giới tính Nữ ");
                System.out.println("Nhập 3 = Giới tính Thứ 3 ");
                String tempGender = scanner.nextLine();
                PersonCheckException.checkGender(tempGender);
                switch (tempGender) {
                    case "1":
                        gender = "Nam";
                        break;
                    case "2":
                        gender = "Nữ";
                        break;
                    case "3":
                        gender = "Giới tính thứ 3";
                        break;
                }
                break;
            } catch (PersonException e) {
                System.out.println("Bạn đã nhập sai,vui lòng nhập lại!");
            }
        }
        String technique;
        while (true) {
            try {
                System.out.println("Mời bạn nhập chuyên môn Giáo Viên: ");
                technique = scanner.nextLine();
                PersonCheckException.checkTenique(technique);
                break;
            } catch (PersonException e) {
                System.out.println(e.getMessage());
            }
        }
        LocalDate birth;
        while (true) {
            try {
                System.out.println("Mời bạn nhập ngày tháng năm sinh theo định dạng dd/mm/yyyy");
                String date = scanner.nextLine();
                PersonCheckException.checkDate(date);
                birth = LocalDate.parse(date, fm);
                PersonCheckException.checkBirth(birth);
                break;
            } catch (DateTimeParseException | ParseException e) {
                System.out.println(e.getMessage() + "Bạn nhập sai định dạng!Vui lòng nhập lại");
            } catch (PersonException e) {
                System.out.println(e.getMessage());
            }
        }

        return new Teacher(code, name, gender, birth, technique);
    }

    private String getinfo(Teacher teacher) {
        return String.format("%s,%s,%s,%s,%s", teacher.getCode(), teacher.getName()
                , teacher.getGender(), teacher.getBirth().format(fm), teacher.getTechnique());
    }

    @Override
    public void add() {

    }

    @Override
    public void display() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void sort() {

    }

    @Override
    public void find() {

    }
}
