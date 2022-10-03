package case_study_module2.service.implEmployeeService;

import case_study_module2.model.Customer;
import case_study_module2.model.Employee;
import case_study_module2.service.IEmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Employee> employeeList = new ArrayList<>();

    @Override
    public void displayEmplyoee() {
        for (Employee i : employeeList) {
            System.out.println(i);
        }
    }

    @Override
    public void addEmployee() {
        Employee employee = infoEmplyoee();
        employeeList.add(employee);
        System.out.println("Successfully added new!");
    }

    private Employee infoEmplyoee() {
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
        switch (choice) {
            case "1":
                gender = "fale";
                break;
            case "2":
                gender = "female";
                break;
            case "3":
                gender = "3rd sex";
                break;
        }
        System.out.println("Enter idcard to be corrected!");
        int idCard = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Phone Number to be corrected!");
        int numPhone = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter email to be corrected!");
        String email = scanner.nextLine();
        String level = "";
        System.out.println("Enter rank customer to be corrected!");
        System.out.println("1=Postgraduate,2=University,3=college,4=Intermediate");
        String choice1 = scanner.nextLine();
        switch (choice1) {
            case "1":
                level = "Postgraduate";
                break;
            case "2":
                level = "University";
                break;
            case "3":
                level = "College";
                break;
            case "4":
                level = "Intermediate";
                break;
        }
        System.out.println("Enter address to be corrected!");
        double wage = Double.parseDouble(scanner.nextLine());
        return new Employee(code, name, birtth, gender, idCard, numPhone, email, level, wage);
    }


    @Override
    public void editEmployee() {
        boolean flagDelete = false;
        System.out.println("Enter the employee code to be corrected!");
        String code = (scanner.nextLine());
        for (Employee employee : employeeList) {
            if (employee.getCode().equals(code)) {
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
                                employee.setCode(code1);
                                break;
                            case 2:
                                System.out.println("Enter full name to be corrected!");
                                String name = scanner.nextLine();
                                employee.setFullName(name);
                                break;
                            case 3:
                                System.out.println("3.Enter the date of birth to be corrected!");
                                String birtth = scanner.nextLine();
                                employee.setBirth(birtth);
                                break;
                            case 4:
                                System.out.println("Enter gender to be corrected!");
                                System.out.println("Enter 1 = male");
                                System.out.println("Enter 2 = female");
                                System.out.println("Enter 3 = 3rd sex");
                                String choice2 = (scanner.nextLine());
                                switch (choice2) {
                                    case "1": {
                                        String gender = "fale";
                                        employee.setGender(gender);
                                        break;
                                    }
                                    case "2": {
                                        String gender = "female";
                                        employee.setGender(gender);
                                        break;
                                    }
                                    case "3": {
                                        String gender = "3rd sex";
                                        employee.setGender(gender);
                                        break;
                                    }
                                }
                                break;
                            case 5:
                                System.out.println("Enter idcard to be corrected!");
                                int idCard = Integer.parseInt(scanner.nextLine());
                                employee.setIdCard(idCard);
                                break;
                            case 6:
                                System.out.println("Enter Phone Number to be corrected!");
                                int numPhone = Integer.parseInt(scanner.nextLine());
                                employee.setNumberPhone(numPhone);
                                break;
                            case 7:
                                System.out.println("Enter email to be corrected!");
                                String email = scanner.nextLine();
                                employee.setEmail(email);
                                break;
                            case 8:
                                System.out.println("Enter rank customer to be corrected!");
                                String level = scanner.nextLine();
                                employee.setLevel(level);
                                break;
                            case 9:
                                System.out.println("9.Enter address to be corrected!");
                                double wage = Double.parseDouble(scanner.nextLine());
                                employee.setWage(wage);
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
