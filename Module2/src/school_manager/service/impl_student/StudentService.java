package school_manager.service.impl_student;

import school_manager.controller.PersonController;
import school_manager.model.Student;
import school_manager.service.IStudentService;
import until.PersonCheckException;
import until.PersonException;
import until.SortNameStudent;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class StudentService implements IStudentService {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Student> studentList = new ArrayList<>();
    private final DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    private void writeFile(List<Student> studentList) {
        File file = new File("src/school_manager/data/student.csv");
        if (!file.exists()) {
            System.out.println("File không tồn tại");
        }
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Student i : studentList) {
                bufferedWriter.write(getinfo(i));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            assert bufferedWriter != null;
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private List<Student> getAllStudentFile() {
        List<Student> studentList = new ArrayList<>();
        File file = new File("src/school_manager/data/student.csv");
        if (!file.exists()) {
            System.out.println("File này không tồn tại");
        }
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            Student student;
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    info = line.split(",");
                    student = new Student(info[0], info[1], info[2], LocalDate.parse(info[3], fm), info[4], Double.parseDouble(info[5]));
                    studentList.add(student);
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
        return studentList;
    }

    @Override
    public void addStudent() {
        studentList = getAllStudentFile();
        if (studentList.size() == 0) {
            System.out.println("File này rỗng");
        }
        Student student = infoStudent();
        studentList.add(student);
        System.out.println("Thêm mới thành công");
        writeFile(studentList);
    }

    @Override
    public void displayAllStudent() {
        studentList = getAllStudentFile();
        if (studentList.size() == 0) {
            System.out.println("File này rỗng không có danh sách hiển thị");
            PersonController.personMenu();
        }
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Override
    public void removeStudent() {
        studentList = getAllStudentFile();
        if (studentList.size() == 0) {
            System.out.println("File này rỗng không có đối tượng để xóa");
            PersonController.personMenu();
        }
        String code;
        while (true) {
            try {
                System.out.println("Mời bạn nhập mã học sinh muốn xóa");
                code = scanner.nextLine();
                PersonCheckException.checkCode(code);
                break;
            } catch (PersonException e) {
                System.out.println(e.getMessage());
            }
        }
        boolean flagDelete = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getCode().equals(code)) {
                System.out.println("Bạn có chắc muốn xóa học sinh này không? Nhập Y: yes, N: no");
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
        writeFile(studentList);
    }

    @Override
    public void findStudyName() {
        studentList = getAllStudentFile();
        if (studentList.size() == 0) {
            System.out.println("File này rỗng không thể tìm kiếm");
            PersonController.personMenu();
        }
        String name;
        while (true) {
            try {
                System.out.println("Mời bạn nhập tên học sinh muốn tìm ");
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
        for (Student student : studentList) {
            if (student.getName().contains(name)) {
                System.out.println(student);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Không tìm thấy đối tượng cần tìm");
        }
    }

    @Override
    public void findStudyCode() {
        studentList = getAllStudentFile();
        if (studentList.size() == 0) {
            System.out.println("File này rỗng không thể tìm kiếm");
            PersonController.personMenu();
        }
        String code;
        while (true) {
            try {
                System.out.println("Mời bạn nhập mã học sinh muốn tìm");
                code = scanner.nextLine();
                PersonCheckException.checkCode(code);
                break;
            } catch (PersonException e) {
                System.out.println(e.getMessage());
            }
        }
        boolean flag = false;
        for (Student student : studentList) {
            if (student.getCode().equals(code)) {
                System.out.println(student);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Không tìm thấy đối tượng cần tìm");
        }

    }

    @Override
    public void sortStudy() {
        studentList = getAllStudentFile();
        if (studentList.size() == 0) {
            System.out.println("File này đang rỗng,không thể sắp xếp");
            PersonController.personMenu();
        }
        studentList.sort(new SortNameStudent());
//        studentList.sort(new SortNameStudent().reversed());
        writeFile(studentList);
    }


    public Student infoStudent() {
        String code;
        while (true) {
            try {
                System.out.println("Mời bạn nhập mã học sinh: \n" +
                        "Mã bao gồm 1 chữ cái đầu viết hoa và 2 số");
                code = scanner.nextLine();
                PersonCheckException.checkCode(code);
                PersonCheckException.checkDuplicatedCode(code, studentList);
                break;
            } catch (PersonException e) {
                System.out.println(e.getMessage());
            }
        }
        String name;
        while (true) {
            try {
                System.out.println("Mời bạn nhập tên học sinh: ");
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
                System.out.println("Mời bạn nhập giới tính học sinh: ");
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
        String nameClass;
        while (true) {
            try {
                System.out.println("Mời bạn nhập tên lớp: \n" + "Định dạng lớp: 2 số + 1 chữ cái in hoa ");
                nameClass = scanner.nextLine();
                PersonCheckException.checkNameClass(nameClass);
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
            } catch (DateTimeParseException e) {
                System.out.println("Bạn đã nhập sai!Vui lòng nhập lại");
            } catch (ParseException e) {
                System.out.println(e.getMessage() + "Năm không nhuận không có ngày này");
            } catch (PersonException e) {
                System.out.println(e.getMessage());
            }
        }
        double score;
        while (true) {
            try {
                System.out.println("Mời bạn nhập điểm của học sinh: ");
                score = Double.parseDouble(scanner.nextLine());
                PersonCheckException.checkScore(score);
                break;
            } catch (NumberFormatException | PersonException e) {
                System.out.println(e.getMessage());
            }
        }

        return new Student(code, name, gender, birth, nameClass, score);
    }

    private String getinfo(Student student) {
        return String.format("%s,%s,%s,%s,%s,%s", student.getCode(), student.getName()
                , student.getGender(), student.getBirth().format(fm), student.getNameClass(), student.getScore());
    }
}
