package school_manager.service.impl_student;

import school_manager.model.Student;
import school_manager.service.IStudentService;
import school_manager.service.util.NameException;
import school_manager.service.util.ScoreException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> studentList = new ArrayList<>();

    @Override
    public void addStudent() {
        studentList = getAllStudentFile();
        Student student = infoStudent();
        studentList.add(student);
        System.out.println("Thêm mới thành công");
        writeFile(studentList);
    }

    private void writeFile(List<Student> studentList) {
        try {
            File file = new File("src/school_manager/data/student.csv");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Student i : studentList) {
                bufferedWriter.write(i.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Student> getAllStudentFile() {
        try {
            File file = new File("src/school_manager/data/student.csv");
            if (!file.exists()) {
                throw new Exception();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            studentList = new ArrayList<>();
            String line;
            String[] info;
            Student student;
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    info = line.split(",");
                    student = new Student(info[0], info[1], info[2], info[3], info[4], Double.parseDouble(info[5]));
                    studentList.add(student);
                } catch (NumberFormatException e) {
//                    e.printStackTrace();
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public void displayAllStudent() {
        studentList = getAllStudentFile();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Override
    public void removeStudent() {
        studentList = getAllStudentFile();
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
        writeFile(studentList);
    }

    @Override
    public void findStudyName() {
        studentList = getAllStudentFile();
        System.out.println("Nhập tên muốn tìm");
        String name = scanner.nextLine();
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
        System.out.println("Nhập code muốn tìm");
        String code = scanner.nextLine();
        boolean flag = false;
        for (Student student : studentList) {
            if (student.getCode().equals(code)) {
                System.out.println(student);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Không tìm thấy đối tượng cần tìm");
        }

    }

    @Override
    public void sortStudy() {
        studentList = getAllStudentFile();
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
        writeFile(studentList);
    }


    public Student infoStudent() {
        System.out.print("Mời bạn nhập mã học sinh: ");
        String code = scanner.nextLine();
        String name;
        while (true) {
            try {
                System.out.print("Mời bạn nhập tên học sinh: ");
                name = scanner.nextLine();
                checkName(name);
                break;
            } catch (NameException e) {
                System.out.println(e.getMessage());
            }
        }
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
        double score;
        while (true) {
            try {
                System.out.print("Mời bạn nhập điểm của học sinh: ");
                score = Double.parseDouble(scanner.nextLine());
                checkScore(score);
                break;
            } catch (ScoreException e) {
                System.out.println("Số này sai đinh dạng!vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println(e.getMessage() + "Số này sai đinh dạng!vui lòng nhập lại");
            }
        }
        System.out.println("Mời bạn nhập ngày sinh Sinh Viên:");
        String birth = scanner.nextLine();
        return new Student(code, name, gender, birth, nameClass, score);
    }

    public void testStudentList() {
        studentList.add(new Student("5", "Bảo", "1", "12/12/1995", "c0722g1", 9));
        studentList.add(new Student("1", "An", "2", "12/11/1995", "c0722g1", 8));
        studentList.add(new Student("2", "Bảo", "2", "12/10/1995", "c0722g1", 8));
        studentList.add(new Student("3", "Kha", "1", "12/9/1995", "c0722g1", 7));
        studentList.add(new Student("4", "Nam", "1", "12/12/1995", "c0722g1", 9));
        System.out.println("thêm mới thành công");
    }

    public static void checkScore(double a) throws ScoreException {
        if (a < 0 || a > 10) {
            throw new ScoreException("Số này sai đinh dạng!vui lòng nhập lại");
        }
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
