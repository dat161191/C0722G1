package school_manager.service.impl_student;

import school_manager.controller.PersonController;
import school_manager.model.AccountBank;
import school_manager.service.IStudentService;
import school_manager.until.PersonCheckException;
import school_manager.until.PersonException;
import school_manager.until.SortNameStudent;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class StudentService implements IStudentService {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<AccountBank> accountBankList = new ArrayList<>();
    private final DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    private void writeFile(List<AccountBank> accountBankList) {
        File file = new File("src/school_manager/data/student.csv");
        if (!file.exists()) {
            System.out.println("File không tồn tại");
        }
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (AccountBank i : accountBankList) {
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

    private List<AccountBank> getAllStudentFile() {
        List<AccountBank> accountBankList = new ArrayList<>();
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
            AccountBank accountBank;
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    info = line.split(",");
                    accountBank = new AccountBank(info[0], info[1], info[2], LocalDate.parse(info[3], fm), info[4], Double.parseDouble(info[5]));
                    accountBankList.add(accountBank);
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
        return accountBankList;
    }

    @Override
    public void addStudent() {
        accountBankList = getAllStudentFile();
        if (accountBankList.size() == 0) {
            System.out.println("File này rỗng");
        }
        AccountBank accountBank = infoStudent();
        accountBankList.add(accountBank);
        System.out.println("Thêm mới thành công");
        writeFile(accountBankList);
    }

    @Override
    public void displayAllStudent() {
        accountBankList = getAllStudentFile();
        if (accountBankList.size() == 0) {
            System.out.println("File này rỗng không có danh sách hiển thị");
            PersonController.personMenu();
        }
        for (AccountBank accountBank : accountBankList) {
            System.out.println(accountBank);
        }
    }

    @Override
    public void removeStudent() {
        accountBankList = getAllStudentFile();
        if (accountBankList.size() == 0) {
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
        for (int i = 0; i < accountBankList.size(); i++) {
            if (accountBankList.get(i).getCode().equals(code)) {
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
                    accountBankList.remove(i);
                    System.out.println("Xóa thành công");
                }
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.out.println("Không tìm thấy đối tượng cần xóa.");
        }
        writeFile(accountBankList);
    }

    @Override
    public void findStudyName() {
        accountBankList = getAllStudentFile();
        if (accountBankList.size() == 0) {
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
        for (AccountBank accountBank : accountBankList) {
            if (accountBank.getName().contains(name)) {
                System.out.println(accountBank);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Không tìm thấy đối tượng cần tìm");
        }
    }

    @Override
    public void findStudyCode() {
        accountBankList = getAllStudentFile();
        if (accountBankList.size() == 0) {
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
        for (AccountBank accountBank : accountBankList) {
            if (accountBank.getCode().equals(code)) {
                System.out.println(accountBank);
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
        accountBankList = getAllStudentFile();
        if (accountBankList.size() == 0) {
            System.out.println("File này đang rỗng,không thể sắp xếp");
            PersonController.personMenu();
        }
        accountBankList.sort(new SortNameStudent());
//        studentList.sort(new SortNameStudent().reversed());
        writeFile(accountBankList);
    }


    public AccountBank infoStudent() {
        String code;
        while (true) {
            try {
                System.out.println("Mời bạn nhập mã học sinh: \n" +
                        "Mã bao gồm 1 chữ cái đầu viết hoa và 2 số");
                code = scanner.nextLine();
                PersonCheckException.checkCode(code);
                PersonCheckException.checkDuplicatedCode(code, accountBankList);
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
                System.out.println(e.getMessage()+"Bạn nhập sai vui lòng nhập lại");
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

        return new AccountBank(code, name, gender, birth, nameClass, score);
    }

    private String getinfo(AccountBank accountBank) {
        return String.format("%s,%s,%s,%s,%s,%s", accountBank.getCode(), accountBank.getName()
                , accountBank.getGender(), accountBank.getBirth().format(fm), accountBank.getNameClass(), accountBank.getScore());
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
