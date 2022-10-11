package case_study_module2.service.impl_customer_service;

import case_study_module2.model.Person.Customer;
import case_study_module2.service.ICustomerService;
import case_study_module2.util.FuramaCheckException;
import case_study_module2.util.FuramaException;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Customer> customerList = new ArrayList<>();
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void displayCustomer() {
        customerList = readFile();
        if (customerList.size() == 0) {
            System.out.println("This list is empty!");
        }
        for (Customer i : customerList) {
            System.out.println(i);
        }
    }

    @Override
    public void addCustomer() {
        customerList = readFile();
        Customer customer = infoCustomer();
        customerList.add(customer);
        System.out.println("Successfully added new!");
        writeFile(customerList);
    }

    private Customer infoCustomer() {
        String code;
        while (true) {
            try {
                System.out.println("Enter code to be corrected! Format: 0-9");
                code = scanner.nextLine();
                FuramaCheckException.checkCode(code);
                if ((FuramaCheckException.checkDuplicatedCode(code, customerList))) {
                    throw new FuramaException("");
                }
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
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
        LocalDate birtth;
        while (true) {
            try {
                System.out.println("Enter the date of birth to be corrected!");
                String date = scanner.nextLine();
                FuramaCheckException.checkDate(date);
                birtth = LocalDate.parse(scanner.nextLine(), dateTimeFormatter);
                FuramaCheckException.checkBirth(birtth);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }


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

        String rank = "Undefined";
        while (true) {
            try {
                System.out.println("Enter rank customer to be corrected!");
                System.out.println("1=Diamond,2=Platinium,3=Gold,4=Silver,5=Member");
                String choice1 = scanner.nextLine();
                FuramaCheckException.checkRank(choice1);
                switch (choice1) {
                    case "1":
                        rank = "Diamond";
                        break;
                    case "2":
                        rank = "Platinium";
                        break;
                    case "3":
                        rank = "Gold";
                        break;
                    case "4":
                        rank = "Silver";
                        break;
                    case "5":
                        rank = "Member";
                        break;
                }
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        String address;
        while (true) {
            try {
                System.out.println("Enter address to be corrected!");
                address = scanner.nextLine();
                FuramaCheckException.checkAddress(address);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }

        return new Customer(code, name, birtth, gender, idCard, numPhone, email, rank, address);
    }

    @Override
    public void editCustomer() {
        customerList = readFile();
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
        for (Customer customer : customerList) {
            if (customer.getCode().equals(code)) {
                System.out.println("Are you sure you want to edit this employee information? Enter Y= yes, N= no!");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    int choice1 = 0;
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
                        try {
                            System.out.println("Please enter your selection");
                            choice1 = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                        label:
                        switch (choice1) {
                            case 1:
                                String code1;
                                while (true) {
                                    try {
                                        System.out.println("Enter code (String) to be corrected!");
                                        code1 = scanner.nextLine();
                                        FuramaCheckException.checkCode(code1);
                                        break;
                                    } catch (FuramaException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                customer.setCode(code1);
                                break;
                            case 2:
                                String name;
                                while (true) {
                                    try {
                                        System.out.println("Enter full name (String) to be corrected!");
                                        name = scanner.nextLine();
                                        FuramaCheckException.checkFullName(name);
                                        break;
                                    } catch (FuramaException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                customer.setFullName(name);
                                break;
                            case 3:
                                LocalDate birtth;
                                while (true) {
                                    try {
                                        System.out.println("3.Enter the date of birth (String) to be corrected!");
                                        birtth = LocalDate.parse(scanner.nextLine(), dateTimeFormatter);
                                        FuramaCheckException.checkBirth(birtth);
                                        break;
                                    } catch (FuramaException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                customer.setBirth(birtth);
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
                                        customer.setGender(gender);
                                        break label;
                                    }
                                    case "2": {
                                        String gender = "female";
                                        customer.setGender(gender);
                                        break label;
                                    }
                                    case "3": {
                                        String gender = "3rd sex";
                                        customer.setGender(gender);
                                        break label;
                                    }
                                }
                            case 5:
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
                                customer.setIdCard(idCard);
                                break;
                            case 6:
                                String numPhone;
                                while (true) {
                                    try {
                                        System.out.println("Enter Phone Number (Int) to be corrected!");
                                        numPhone = (scanner.nextLine());
                                        FuramaCheckException.checkPhoneNumber(numPhone);
                                        break;
                                    } catch (FuramaException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                customer.setNumberPhone(numPhone);
                                break;
                            case 7:
                                String email;
                                while (true) {
                                    try {
                                        System.out.println("Enter email (String) to be corrected!");
                                        email = scanner.nextLine();
                                        FuramaCheckException.checkEmail(email);
                                        break;
                                    } catch (FuramaException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                customer.setEmail(email);
                                break;
                            case 8:
                                String rank;
                                String choice3 = null;
                                while (true) {
                                    try {
                                        System.out.println("Enter rank customer to be corrected!");
                                        System.out.println("1=Diamond,2=Platinium,3=Gold,4=Silver,5=Member");
                                        choice3 = scanner.nextLine();
                                        FuramaCheckException.checkRank(choice3);
                                        break;
                                    } catch (FuramaException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                switch (choice3) {
                                    case "1":
                                        rank = "Diamond";
                                        customer.setRankCustomer(rank);
                                        break;
                                    case "2":
                                        rank = "Platinium";
                                        customer.setRankCustomer(rank);
                                        break;
                                    case "3":
                                        rank = "Gold";
                                        customer.setRankCustomer(rank);
                                        break;
                                    case "4":
                                        rank = "Silver";
                                        customer.setRankCustomer(rank);
                                        break;
                                    case "5":
                                        rank = "Member";
                                        customer.setRankCustomer(rank);
                                        break;
                                }
                            case 9:
                                String address;
                                while (true) {
                                    try {
                                        System.out.println("9.Enter address to be corrected!");
                                        address = scanner.nextLine();
                                        FuramaCheckException.checkAddress(address);
                                        break;
                                    } catch (FuramaException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
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
        writeFile(customerList);
    }


    private String getInfo(Customer customer) {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", customer.getCode(), customer.getFullName(),
                customer.getBirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                customer.getGender(), customer.getIdCard(), customer.getNumberPhone(), customer.getEmail(), customer.getRankCustomer(), customer.getAddress());
    }

    public List<Customer> readFile() {
        List<Customer> customerList = new ArrayList<>();
        try {
            File file = new File("src/case_study_module2/data/Customer.csv");
            if (!file.exists()) {
                throw new Exception();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            Customer customer;
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    info = line.split(",");
                    customer = new Customer(info[0], info[1], LocalDate.parse(info[2], DateTimeFormatter.ofPattern("dd/MM/yyyy")), info[3], info[4], (info[5]), info[6], info[7], info[8]);
                    customerList.add(customer);
                } catch (NumberFormatException e) {
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return customerList;
    }

    public void writeFile(List<Customer> customerList) {
        try {
            File file = new File("src/case_study_module2/data/Customer.csv");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer i : customerList) {
                bufferedWriter.write(getInfo(i));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
        }
    }

}
