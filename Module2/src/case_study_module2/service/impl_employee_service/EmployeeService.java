package case_study_module2.service.impl_employee_service;

import case_study_module2.model.Person.Employee;
import case_study_module2.service.IEmployeeService;
import case_study_module2.util.FuramaCheckException;
import case_study_module2.util.FuramaException;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Employee> employeeList = new ArrayList<>();
//    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    @Override
    public void displayEmplyoee() {
        employeeList = readfile();
        if (employeeList.size() == 0) {
            System.out.println("This list is empty!");
        }
        for (Employee i : employeeList) {
            System.out.println(i);

        }
    }

    @Override
    public void addEmployee() {
        employeeList = readfile();
        Employee employee = infoEmplyoee();
        employeeList.add(employee);
        System.out.println("Successfully added new!");
        writeFile(employeeList);
    }

    private Employee infoEmplyoee() {
        String code = getCode();
        String name = getName();
        LocalDate birtth = FuramaCheckException.getLocalDate();

        String gender = null;
        while (true) {
            try {
                System.out.println("Enter gender to be corrected!");
                System.out.println("Enter 1 = male");
                System.out.println("Enter 2 = female");
                System.out.println("Enter 3 = 3rd sex");
                String choice = (scanner.nextLine());
                FuramaCheckException.checkGender(choice);
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
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        String idCard = getIDCard();
        String numPhone = getnumPhone();
        String email = getEmail();
        String level = "^:^";
        while (true) {
            try {
                System.out.println("Enter choice rank Employee to be corrected!");
                System.out.println("1=Postgraduate,2=University,3=college,4=Intermediate");
                String choice1 = scanner.nextLine();
                FuramaCheckException.checkLevel(choice1);
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
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }

        String position = "^:^";
        while (true) {
            try {
                System.out.println("Enter choice Position to be corrected");
                System.out.println("1.Receptionist,2.Waiter,3.Specialist,4.Supervisor,5.Manager,6.Director.");
                String choice2 = scanner.nextLine();
                FuramaCheckException.checkPosition(choice2);
                switch (choice2) {
                    case "1":
                        position = "Receptionist";
                        break;
                    case "2":
                        position = "Waiter";
                        break;
                    case "3":
                        position = "Specialist";
                        break;
                    case "4":
                        position = "Supervisor";
                        break;
                    case "5":
                        position = "Manager";
                        break;
                    case "6":
                        position = "Director";
                        break;
                }
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }

        int wage = getWage();

        return new Employee(code, name, birtth, gender, idCard, numPhone, email, level, position, wage);

    }

    private int getWage() {
        int wage;
        while (true) {
            try {
                System.out.println("Enter wage to be corrected!");
                wage = Integer.parseInt(scanner.nextLine());
                FuramaCheckException.checkWage(wage);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        return wage;
    }

    private String getEmail() {
        String email;
        while (true) {
            try {
                System.out.println("Enter email to be corrected!");
                email = scanner.nextLine();
                FuramaCheckException.checkEmail(email);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        return email;
    }

    private String getnumPhone() {
        String numPhone;
        while (true) {
            try {
                System.out.println("Enter Phone Number to be corrected!");
                numPhone = (scanner.nextLine());
                FuramaCheckException.checkPhoneNumber(numPhone);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        return numPhone;
    }

    private String getIDCard() {
        String idCard;
        while (true) {
            try {
                System.out.println("Enter idcard to be corrected!");
                idCard = (scanner.nextLine());
                FuramaCheckException.checkIDCard(idCard);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        return idCard;
    }

    private String getName() {
        String name;
        while (true) {
            try {
                System.out.println("Enter full name to be corrected!");
                name = scanner.nextLine();
                FuramaCheckException.checkFullName(name);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        return name;
    }

    private String getCode() {
        String code;
        while (true) {
            try {
                System.out.println("Enter code to be corrected!");
                code = scanner.nextLine();
                FuramaCheckException.checkCode(code);
                if (FuramaCheckException.checkDuplicatedCode(code,employeeList)) {
                    break;
                }
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        return code;
    }


    @Override
    public void editEmployee() {
        employeeList = readfile();
        boolean flagDelete = false;
        String code;
        while (true) {
            try {
                System.out.println("Enter the employee code to be corrected!");
                code = (scanner.nextLine());
                FuramaCheckException.checkCode(code);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        for (Employee employee : employeeList) {
            if (employee.getCode().equals(code)) {
                System.out.println("Are you sure you want to edit this employee information? Enter Y= yes, N= no!");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    int choice1 = 0;
                    loop:
                    while (true) {
                        System.out.println("1.Edit code (String) Employee!");
                        System.out.println("2.Edit Full Name (String) Employee!");
                        System.out.println("3.Edit birth (String) Employee!");
                        System.out.println("4.Edit gender!");
                        System.out.println("5.Edit ID Card (Int)");
                        System.out.println("6.Edit Phone Number(Int)");
                        System.out.println("7.Edit Email(String)");
                        System.out.println("8.Edit Level Employee");
                        System.out.println("9.Edit Wage Employee (Double)");
                        System.out.println("10.Edit Positon Employee (Double)");
                        System.out.println("11.Back to Menu!");
                        try {
                            System.out.println("Please enter your selection");
                            choice1 = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                        label:
                        switch (choice1) {
                            case 1:
                                String code1 = getCode();
                                employee.setCode(code1);
                                break;
                            case 2:
                                String name = getName();
                                employee.setFullName(name);
                                break;
                            case 3:
                                LocalDate birtth = FuramaCheckException.getLocalDate();
                                employee.setBirth(birtth);
                                break;
                            case 4:
                                String choice2;
                                while (true) {
                                    try {
                                        System.out.println("Enter gender to be corrected!");
                                        System.out.println("Enter 1 = male");
                                        System.out.println("Enter 2 = female");
                                        System.out.println("Enter 3 = 3rd sex");
                                        choice2 = (scanner.nextLine());
                                        FuramaCheckException.checkGender(choice2);
                                        break;
                                    } catch (FuramaException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                switch (choice2) {
                                    case "1": {
                                        String gender = "fale";
                                        employee.setGender(gender);
                                        break label;
                                    }
                                    case "2": {
                                        String gender = "female";
                                        employee.setGender(gender);
                                        break label;
                                    }
                                    case "3": {
                                        String gender = "3rd sex";
                                        employee.setGender(gender);
                                        break label;
                                    }
                                }
                            case 5:
                                String idCard = getIdCard();
                                employee.setIdCard(idCard);
                                break;
                            case 6:
                                String numPhone = getnumPhone();
                                employee.setNumberPhone(numPhone);
                                break;
                            case 7:
                                String email = this.getEmail();
                                employee.setEmail(email);
                                break;
                            case 8:
                                String templevel;
                                while (true) {
                                    try {
                                        System.out.println("Enter level Employee to be corrected!");
                                        System.out.println("1=Postgraduate,2=University,3=College,4=Intermediate");
                                        templevel = scanner.nextLine();
                                        FuramaCheckException.checkLevel(templevel);
                                        break;
                                    } catch (FuramaException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }

                                switch (templevel) {
                                    case "1": {
                                        String level = "Postgraduate";
                                        employee.setLevel(level);
                                        break label;
                                    }
                                    case "2": {
                                        String level = "University";
                                        employee.setLevel(level);
                                        break label;
                                    }
                                    case "3": {
                                        String level = "College";
                                        employee.setLevel(level);
                                        break label;
                                    }
                                    case "4": {
                                        String level = "Intermediate";
                                        employee.setLevel(level);
                                        break label;
                                    }
                                }
                            case 9:
                                int wage = this.getWage();
                                employee.setWage(wage);
                                break;
                            case 10:
                                String choicePosition;
                                while (true) {
                                    try {
                                        System.out.println("9.Enter Position (String) to be corrected!");
                                        System.out.println("1.Receptionist,2.Waiter,3.Specialist,4.Supervisor,5.Manager,6.Director.");
                                        choicePosition = (scanner.nextLine());
                                        FuramaCheckException.checkPosition(choicePosition);
                                        break;
                                    } catch (FuramaException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                switch (choicePosition) {
                                    case "1": {
                                        String position = "Receptionist";
                                        employee.setPosition(position);
                                        break label;
                                    }
                                    case "2": {
                                        String position = "Waiter";
                                        employee.setPosition(position);
                                        break label;
                                    }
                                    case "3": {
                                        String position = "Specialist";
                                        employee.setPosition(position);
                                        break label;
                                    }
                                    case "4": {
                                        String position = "Supervisor";
                                        employee.setPosition(position);
                                        break label;
                                    }
                                    case "5": {
                                        String position = "Manager";
                                        employee.setPosition(position);
                                        break label;
                                    }
                                    case "6": {
                                        String position = "Director";
                                        employee.setPosition(position);
                                        break label;
                                    }
                                }
                            case 11:
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
        writeFile(employeeList);
    }

    private String getIdCard() {
        String idCard;
        while (true) {
            try {
                System.out.println("Enter idcard (Int) to be corrected!");
                idCard = (scanner.nextLine());
                FuramaCheckException.checkIDCard(idCard);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        return idCard;
    }

    public String getInfo(Employee employee) {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", employee.getCode(), employee.getFullName(),
                employee.getBirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                employee.getGender(), employee.getIdCard(), employee.getNumberPhone(), employee.getEmail(), employee.getLevel(), employee.getPosition(), employee.getWage());
    }

    private List<Employee> readfile() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            File file = new File("src/case_study_module2/data/Employee.csv");
            if (!file.exists()) {
                throw new Exception();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            Employee employee;
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    info = line.split(",");
                    employee = new Employee(info[0], info[1], LocalDate.parse(info[2], DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                            info[3], info[4], info[5], info[6], info[7], info[8], Integer.parseInt(info[9]));
                    employeeList.add(employee);
                } catch (NumberFormatException ignored) {
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    private void writeFile(List<Employee> employeeList) {
        try {
            File file = new File("src/case_study_module2/data/Employee.csv");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee i : employeeList) {
                bufferedWriter.write(getInfo(i));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
