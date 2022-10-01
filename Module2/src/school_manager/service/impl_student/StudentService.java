package school_manager.service.impl_student;

import school_manager.model.Student;
import school_manager.service.IStudentService;
import school_manager.service.util.PersonCheckException;
import school_manager.service.util.PersonException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static final Scanner scanner = new Scanner(System.in);
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
        List<Student> studentList = new ArrayList<>();
        try {
            File file = new File("src/school_manager/data/student.csv");
            if (!file.exists()) {
                throw new Exception();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            String[] info;
            Student student;
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    info = line.split(",");
                    student = new Student(info[0], info[1], info[2], info[3], info[4], Double.parseDouble(info[5]));
                    studentList.add(student);
                } catch (NumberFormatException e) {
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
        String code;
        while (true) {
            try {
                System.out.println("Mời bạn nhập mã học sinh: \n"+
                        "Mã bao gồm 1 chữ cái đầu viết hoa và 2 số");
                code = scanner.nextLine();
                PersonCheckException.checkCode(code);
                boolean flagCheck = false;
                for (Student student : studentList) {
                    if (student.getCode().equals(code)) {
                        flagCheck = true;
                        break;
                    }
                }
                if (flagCheck) {
                    System.out.println("Mã đã bị trùng,Vui lòng nhập lại");
                } else {
                    break;
                }
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
            } catch (Exception e) {
                System.out.println("Tên Này sai định dạng vui lòng nhập lại");
            }
        }
        String gender;
        while (true) {
            try {
                System.out.println("Mời bạn nhập giới tính học sinh: ");
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
        String nameClass;
        while (true) {
            try {
                System.out.println("Mời bạn nhập tên lớp: \n"+"Định dạng lớp: 2 số + 1 chữ cái in hoa ");
                nameClass = scanner.nextLine();
                PersonCheckException.checkNameClass(nameClass);
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
        double score;
        while (true) {
            try {
                System.out.println("Mời bạn nhập điểm của học sinh: ");
                score = Double.parseDouble(scanner.nextLine());
                PersonCheckException.checkScore(score);
                break;
            } catch (PersonException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Điểm này không đúng định dạng!Vui lòng nhập lại");
            }
        }

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
}
