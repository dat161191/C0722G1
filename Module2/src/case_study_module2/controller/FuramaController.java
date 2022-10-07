package case_study_module2.controller;

import case_study_module2.service.*;
import case_study_module2.service.impl_booking_service.BookingService;
import case_study_module2.service.impl_contracts.ContractsService;
import case_study_module2.service.impl_customer_service.CustomerService;
import case_study_module2.service.impl_employee_service.EmployeeService;
import case_study_module2.service.impl_facility_service.FacilityService;
import case_study_module2.service.impl_promotion.PromotionService;

import java.util.Scanner;

public class FuramaController {
    static Scanner scanner = new Scanner(System.in);
    private static final IPromotionService iPromotionService = new PromotionService();
    private static final IBookingService iBookingService = new BookingService();
    private static final IFacilityService iFacilityService = new FacilityService();
    private static final ICustomerService iCustomerService = new CustomerService();
    private static final IEmployeeService iEmployeeService = new EmployeeService();
    private static final IContractsService iContractsService = new ContractsService();

    public static void displayMainMenu() {
        while (true) {
            System.out.println("†=========MENU==========†");
            System.out.println("1.Employee Management");
            System.out.println("2.Customer Management");
            System.out.println("3.Facility Management ");
            System.out.println("4.Booking Management");
            System.out.println("5.Promotion Management");
            System.out.println("6.Exit");
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
                    manageEmployeeMeNu();
                    break;
                case 2:
                    manageCustomerMeNu();
                    break;
                case 3:
                    manageFacilityMeNu();
                    break;
                case 4:
                    manageBookingMeNu();
                    break;
                case 5:
                    managePromotionMeNu();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("You have entered false! please re-enter");
            }

        }
    }

    private static void managePromotionMeNu() {
        loop:
        while (true) {
            System.out.println("1.Display list customers use service");
            System.out.println("2.Display list customers get voucher");
            System.out.println("3.Return main menu");
            int choice = 0;
            try {
                System.out.println("Please enter your selection");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            switch (choice) {
                case 1:
                    iPromotionService.DisplayCustomersUseService();
                    break;
                case 2:
                    iPromotionService.DisplayCustomersGetVoucher();
                    break;
                case 3:
                    break loop;
                default:
                    System.out.println("You have entered false! please re-enter");
            }
        }
    }

    private static void manageBookingMeNu() {
        loop:
        while (true) {
            System.out.println("1.Display list Booking");
            System.out.println("2.Add new Booking");
            System.out.println("3.Create new constracts");
            System.out.println("4.Display list constacts");
            System.out.println("5.Edit constacts");
            System.out.println("6.Return main menu");
            int choice = 0;
            try {
                System.out.println("Please enter your selection");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            switch (choice) {
                case 1:
                    iBookingService.displayBooking();
                    break;
                case 2:
                    iBookingService.addBooking();
                    break;
                case 3:
                    iContractsService.createNewContracts();
                    break;
                case 4:
                    iContractsService.displayListContracts();
                    break;
                case 5:
                    iContractsService.editContracts();
                    break;
                case 6:
                    break loop;
                default:
                    System.out.println("You have entered false! please re-enter");
            }
        }
    }

    private static void manageFacilityMeNu() {
        loop:
        while (true) {
            System.out.println("1.Display list Facility");
            System.out.println("2.Add new Facility");
            System.out.println("3.Display list Facility maintenance");
            System.out.println("4.Return main menu");
            int choice = 0;
            try {
                System.out.println("Please enter your selection");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            switch (choice) {
                case 1:
                    iFacilityService.displayFacility();
                    break;
                case 2:
                    loop1:
                    while (true) {
                        System.out.println("1.Add New Villa");
                        System.out.println("2.Add New House");
                        System.out.println("3.Add New Room");
                        System.out.println("4.Back to MeNu");
                        int choice1 = 0;
                        try {
                            System.out.println("Please enter your selection");
                            choice1 = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println(e.getMessage());
                        }
                        switch (choice1) {
                            case 1:
                                iFacilityService.addVilla();
                                break;
                            case 2:
                                iFacilityService.addHouse();
                                break;
                            case 3:
                                iFacilityService.addRoom();
                                break;
                            case 4:
                                break loop1;
                            default:
                                System.out.println("You have entered false! please re-enter");
                        }
                    }

                    break;
                case 3:
                    iFacilityService.displayFacilityMaintenance();
                    break;
                case 4:
                    break loop;
                default:
                    System.out.println("You have entered false! please re-enter");
            }
        }
    }

    private static void manageCustomerMeNu() {
        loop:
        while (true) {
            System.out.println("1.Display list Customer");
            System.out.println("2.Add new Customer");
            System.out.println("3.Edit Customer");
            System.out.println("4.Return main menu");
            int choice = 0;
            try {
                System.out.println("Please enter your selection");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            switch (choice) {
                case 1:
                    iCustomerService.displayCustomer();
                    break;
                case 2:
                    iCustomerService.addCustomer();
                    break;
                case 3:
                    iCustomerService.editCustomer();
                    break;
                case 4:
                    break loop;
                default:
                    System.out.println("You have entered false! please re-enter");
            }
        }
    }

    private static void manageEmployeeMeNu() {
        loop:
        while (true) {
            System.out.println("1.Display list employee");
            System.out.println("2.Add new employee");
            System.out.println("3.Edit employee");
            System.out.println("4.Return main menu");
            int choice = 0;
            try {
                System.out.println("Please enter your selection");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            switch (choice) {
                case 1:
                    iEmployeeService.displayEmplyoee();
                    break;
                case 2:
                    iEmployeeService.addEmployee();
                    break;
                case 3:
                    iEmployeeService.editEmployee();
                    break;
                case 4:
                    break loop;
                default:
                    System.out.println("You have entered false! please re-enter");
            }
        }
    }
}
