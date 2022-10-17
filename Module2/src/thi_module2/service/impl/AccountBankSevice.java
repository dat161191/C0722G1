package thi_module2.service.impl;


import thi_module2.controller.AccountController;
import thi_module2.model.AccountBank;
import thi_module2.model.AccountPay;
import thi_module2.model.AccountSave;
import thi_module2.util.AccountCheckException;
import thi_module2.util.AccountException;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AccountBankSevice implements IAccountBankService {
    private final Scanner scanner = new Scanner(System.in);
    private static List<AccountBank> accountBankList = new ArrayList<>();
    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void addAccountBank() {
        accountBankList = readFile();
        if (accountBankList.size() == 0) {
            System.out.println("File này rỗng");
        }
        loop:
        while (true) {
            System.out.println("1.Thêm Tài khoản tiết kiệm");
            System.out.println("2.Thêm Tài khoản thanh toán");
            System.out.println("3.Thoát");
            System.out.println("Mời bạn lựa chọn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addAccountSave();
                    break;
                case 2:
                    addAccountPay();
                    break;
                case 3:
                    break loop;
                default:
                    System.out.println("Bạn đã nhập sai!Vui lòng nhập lại");
            }
//            writeFile(accountBankList);
        }
    }

    private void addAccountPay() {
        accountBankList = readFile();
        accountBankList.add(getInfoAccountPay());
        writeFile(accountBankList);
    }


    private void addAccountSave() {
        accountBankList = readFile();
        accountBankList.add(getInfoAccountSave());
        writeFile(accountBankList);
    }

    private AccountPay getInfoAccountPay() {
//        System.out.println("Mời bạn nhập ID");
        int id = accountBankList.size() + 1;
        System.out.println("ID của account là: " + id);
//        System.out.println("Mời bạn nhập Mã tài khoản");
        int code;
        while (true) {
            try {
                code = (int) Math.floor(Math.random() * 1000);
                AccountCheckException.checkDuplicatedCode(code, accountBankList);
                break;
            } catch (AccountException e) {
                System.out.println(e.getMessage());
            }

        }
        System.out.println("Mã tài khoản của account là: " + code);
        System.out.println("Mời bạn nhập Tên chủ tài khoản");
        String name = scanner.nextLine();
        System.out.println("Mời bạn nhập ngày tạo tài khỏan");
        String date = scanner.nextLine();
        LocalDate dateCreate = LocalDate.parse(date, format);
//        System.out.println("Mời bạn nhập số thẻ ");
        int cardNumber;
//        cardNumber = Integer.parseInt(scanner.nextLine());
        while (true) {
            try {
                cardNumber = (int) Math.floor(Math.random() * 1000);
                AccountCheckException.checkDuplicatedCardNumber(cardNumber, accountBankList);
                break;
            } catch (AccountException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Mã thẻ của account là: " + cardNumber);
        System.out.println("Mời bạn nhập số tiền trong tài khoản ");
        int money = Integer.parseInt(scanner.nextLine());
        return new AccountPay(id, code, name, dateCreate, cardNumber, money);
    }

    private AccountSave getInfoAccountSave() {
//        System.out.println("Mời bạn nhập ID");
        int id = accountBankList.size() + 1;
        System.out.println("ID của account là: " + id);
//        System.out.println("Mời bạn nhập Mã tài khoản");
        int code;
        while (true) {
            try {
                code = (int) Math.floor(Math.random() * accountBankList.size());
                AccountCheckException.checkDuplicatedCode(code, accountBankList);
                break;
            } catch (AccountException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Mã tài khoản của account là: " + code);
        System.out.println("Mời bạn nhập Tên chủ tài khoản");
        String name = scanner.nextLine();
        System.out.println("Mời bạn nhập ngày tạo tài khỏan");
        String date = scanner.nextLine();
        LocalDate dateCreate = LocalDate.parse(date, format);
        System.out.println("Mời bạn nhập số tiền tiết kiệm ");
        int money = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập ngày gởi tiết kiệm");
        String dateSave = scanner.nextLine();
        LocalDate dateSave1 = LocalDate.parse(dateSave, format);
        System.out.println("Mời bạn nhập lãi suất ");
        int rate = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập kỳ hạn ");
        int period = Integer.parseInt(scanner.nextLine());
        return new AccountSave(id, code, name, dateCreate, money, dateSave1, rate, period);

    }

    @Override
    public void displayAccountBank() {
        accountBankList = readFile();
        if (accountBankList.size() == 0) {
            System.out.println("File này rỗng không có danh sách hiển thị");
            AccountController.displayMainMenuAccount();
        }
        for (AccountBank i : accountBankList) {
            System.out.println(i);
        }
    }

    @Override
    public void removeAccountBank() {
        accountBankList = readFile();
        if (accountBankList.size() == 0) {
            System.out.println("File này rỗng không có đối tượng để xóa");
            AccountController.displayMainMenuAccount();
        }
        System.out.println("Mời bạn nhập mã tài khoản muốn xóa");
        int code = Integer.parseInt(scanner.nextLine());
        boolean flagDelete = false;
        for (int i = 0; i < accountBankList.size(); i++) {
            if (accountBankList.get(i).getCode() == (code)) {
                System.out.println("Bạn có chắc muốn xóa tài khoản này không? Nhập Y: yes, N: no");
                String choice;
                while (true) {
                    try {
                        choice = scanner.nextLine();
                        AccountCheckException.checkYesNo(choice);
                        break;
                    } catch (AccountException e) {
                        System.out.println(e.getMessage());
                    }
                }
                if (choice.equals("Y")) {
                    accountBankList.remove(i);
                    System.out.println("Xóa thành công");
                    for (int j = 0; j < accountBankList.size(); j++) {
                        accountBankList.get(j).setiD(j + 1);
                    }
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
    public void searchAccountBank() {
        accountBankList = readFile();
        if (accountBankList.size() == 0) {
            System.out.println("File này rỗng không thể tìm kiếm");
            AccountController.displayMainMenuAccount();
        }
        System.out.println("Mời bạn nhập mã tài khoản muốn tìm ");
        int code = Integer.parseInt(scanner.nextLine());

        boolean flag = false;
        for (AccountBank accountBank : accountBankList) {
            if (accountBank.getCode() == (code)) {
                System.out.println(accountBank);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Không tìm thấy đối tượng cần tìm");
        }

    }

    private List<AccountBank> readFile() {
        List<AccountBank> accountBankList = new ArrayList<>();
        File file = new File("src/thi_module2/data/accountBank.csv");
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
                info = line.split(",");
                if (info.length == 8) {
                    accountBank = new AccountSave(Integer.parseInt(info[0]), Integer.parseInt(info[1]), info[2], LocalDate.parse(info[3], format), Integer.parseInt(info[4]),
                            LocalDate.parse(info[5], format), Integer.parseInt(info[6]), Integer.parseInt(info[7]));
                    accountBankList.add(accountBank);
                } else if (info.length == 6) {
                    accountBank = new AccountPay(Integer.parseInt(info[0]), Integer.parseInt(info[1]), info[2], LocalDate.parse(info[3], format), Integer.parseInt(info[4]), Integer.parseInt(info[5]));
                    accountBankList.add(accountBank);
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

    private void writeFile(List<AccountBank> accountBankList) {
        File file = new File("src/thi_module2/data/accountBank.csv");
        if (!file.exists()) {
            System.out.println("File không tồn tại");
        }
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (AccountBank i : accountBankList) {
                bufferedWriter.write(Objects.requireNonNull(getinfo(i)));
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

    private String getinfo(AccountBank i) {
        if (i instanceof AccountSave) {
            return String.format("%s,%s,%s,%s,%s,%s,%s,%s", i.getiD(), i.getCode(), i.getName(), i.getDateCreate().format(format),
                    ((AccountSave) i).getMoneySave(), ((AccountSave) i).getDateSave().format(format), ((AccountSave) i).getRate(), ((AccountSave) i).getPeriod());
        } else if (i instanceof AccountPay) {
            return String.format("%s,%s,%s,%s,%s,%s", i.getiD(), i.getCode(), i.getName(),
                    i.getDateCreate().format(format), ((AccountPay) i).getCardNumber(), ((AccountPay) i).getMoneyInAccount());
        }
        return null;
    }
}