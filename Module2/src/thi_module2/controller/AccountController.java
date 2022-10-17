package thi_module2.controller;

import thi_module2.service.impl.AccountBankSevice;
import thi_module2.service.impl.IAccountBankService;

import java.util.Scanner;

public class AccountController {
    private static Scanner scanner=new Scanner(System.in);
    private static IAccountBankService iAccountBankService=new AccountBankSevice();
    public static void displayMainMenuAccount() {
        while (true) {
            System.out.println("†=========MENU==========†");
            System.out.println("1.Thêm mới Account");
            System.out.println("2.Hiển thị Account");
            System.out.println("3.Xóa Account");
            System.out.println("4.Tìm Account");
            System.out.println("5.Thoát");
            int choice = 0;
            try {
                System.out.println("Please enter your selection");
                choice = Integer.parseInt(scanner.nextLine());
//                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            switch (choice) {
                case 1:
                   iAccountBankService.addAccountBank();
                    break;
                case 2:
                    iAccountBankService.displayAccountBank();
                    break;
                case 3:
                    iAccountBankService.removeAccountBank();
                    break;
                case 4:
                    iAccountBankService.searchAccountBank();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("You have entered false! please re-enter");
            }

        }
    }
}
