package case_study_module2.service.implCustomerService;

import case_study_module2.model.Customer;
import case_study_module2.service.ICustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Customer> customerList = new ArrayList<>();

    @Override
    public void displayCustomer() {
        for (Customer i : customerList) {
            System.out.println(i);
        }
    }

    @Override
    public void addCustomer() {
        Customer customer = infoCustomer();
        customerList.add(customer);
        System.out.println("Successfully added new!");
    }

    private Customer infoCustomer() {
        System.out.println("Enter code to be corrected!");
        String code = scanner.nextLine();
        System.out.println("Enter full name to be corrected!");
        String name = scanner.nextLine();
        System.out.println("3.Enter the date of birth to be corrected!");
        String birtth = scanner.nextLine();
        String gender = "";
        System.out.println("Enter gender to be corrected!");
        System.out.println("Enter 1 = male");
        System.out.println("Enter 2 = female");
        System.out.println("Enter 3 = 3rd sex");
        String choice = (scanner.nextLine());
        if (choice.equals("1")) {
            gender = "fale";
        } else if (choice.equals("2")) {
            gender = "female";
        } else if (choice.equals("3")) {
            gender = "3rd sex";
        }
        System.out.println("Enter idcard to be corrected!");
        int idCard = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Phone Number to be corrected!");
        int numPhone = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter email to be corrected!");
        String email = scanner.nextLine();
        String rank = "";
        System.out.println("Enter rank customer to be corrected!");
        System.out.println("1=Diamond,2=Platinium,3=Gold,4=Silver,5=Member");
        String choice1 = scanner.nextLine();
        if (choice1.equals("1")) {
            rank = "Diamond";
        } else if (choice1.equals("2")) {
            rank = "Platinium";
        } else if (choice1.equals("3")) {
            rank = "Gold";
        } else if (choice1.equals("4")) {
            rank = "Silver";
        } else if (choice1.equals("5")) {
            rank = "Member";
        }
        System.out.println("Enter address to be corrected!");
        String address = scanner.nextLine();
        return new Customer(code, name, birtth, gender, idCard, numPhone, email, rank, address);
    }

    @Override
    public void editCustomer() {
        boolean flagDelete = false;
        System.out.println("Enter the employee code to be corrected!");
        String code = (scanner.nextLine());
        for (Customer customer : customerList) {
            if (customer.getCode().equals(code)) {
                System.out.println("Are you sure you want to edit this employee information? Enter Y= yes, N= no!");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    loop:
                    while (true) {
                        System.out.println("1.Edit code Customer!");
                        System.out.println("2.Edit Full Name Customer!");
                        System.out.println("3.Edit birth Customer!");
                        System.out.println("4.Edit gender!");
                        System.out.println("5.Edit ID Card");
                        System.out.println("6.Edit Phone Number");
                        System.out.println("7.Edit Email");
                        System.out.println("8.Edit Rank Customer");
                        System.out.println("9.Edit Address Customer");
                        System.out.println("10.Back to Menu!");
                        System.out.println("Please enter your selection");
                        int choice1 = Integer.parseInt(scanner.nextLine());
                        switch (choice1) {
                            case 1:
                                System.out.println("Enter code to be corrected!");
                                String code1 = scanner.nextLine();
                                customer.setCode(code1);
                                break;
                            case 2:
                                System.out.println("Enter full name to be corrected!");
                                String name = scanner.nextLine();
                                customer.setFullName(name);
                                break;
                            case 3:
                                System.out.println("3.Enter the date of birth to be corrected!");
                                String birtth = scanner.nextLine();
                                customer.setBirth(birtth);
                                break;
                            case 4:
                                System.out.println("Enter gender to be corrected!");
                                System.out.println("Enter 1 = male");
                                System.out.println("Enter 2 = female");
                                System.out.println("Enter 3 = 3rd sex");
                                String choice2 = (scanner.nextLine());
                                if (choice2.equals("1")) {
                                    String gender = "fale";
                                    customer.setGender(gender);
                                } else if (choice2.equals("2")) {
                                    String gender = "female";
                                    customer.setGender(gender);
                                } else if (choice2.equals("3")) {
                                    String gender = "3rd sex";
                                    customer.setGender(gender);
                                }
                                break;
                            case 5:
                                System.out.println("Enter idcard to be corrected!");
                                int idCard = Integer.parseInt(scanner.nextLine());
                                customer.setIdCard(idCard);
                                break;
                            case 6:
                                System.out.println("Enter Phone Number to be corrected!");
                                int numPhone = Integer.parseInt(scanner.nextLine());
                                customer.setNumberPhone(numPhone);
                                break;
                            case 7:
                                System.out.println("Enter email to be corrected!");
                                String email = scanner.nextLine();
                                customer.setEmail(email);
                                break;
                            case 8:
                                System.out.println("Enter rank customer to be corrected!");
                                String rank = scanner.nextLine();
                                customer.setRankCustomer(rank);
                                break;
                            case 9:
                                System.out.println("9.Enter address to be corrected!");
                                String address = scanner.nextLine();
                                customer.setAddress(address);
                                break;
                            case 10:
                                break loop;
                            default:
                                System.out.println("You have entered false! please re-enter");
                        }
                    }
                }
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.out.println("The object to be edited could not be found!");
        }
    }
}
