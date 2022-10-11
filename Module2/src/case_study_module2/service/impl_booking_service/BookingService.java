package case_study_module2.service.impl_booking_service;

import case_study_module2.model.Booking.Booking;
import case_study_module2.model.Facility.Facility;
import case_study_module2.model.Person.Customer;
import case_study_module2.service.IBookingService;
import case_study_module2.service.impl_customer_service.CustomerService;
import case_study_module2.service.impl_facility_service.FacilityService;
import case_study_module2.util.BookingComparator;
import case_study_module2.util.FuramaCheckException;
import case_study_module2.util.FuramaException;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BookingService implements IBookingService {
    private static Scanner scanner = new Scanner(System.in);
    private static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());
    private static FacilityService facilityService = new FacilityService();
    private static CustomerService customerService = new CustomerService();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final String linkFacility = "src/case_study_module2/data/FacilityInput.csv";
    private static final String linkFacilityMaintenace = "src/case_study_module2/data/FacilityMaintenace.csv";


    @Override
    public void displayBooking() {
        bookingSet = readFile();
        if (bookingSet.size() == 0) {
            System.out.println("This list is empty!");
        }
        for (Booking i : bookingSet) {
            System.out.println(i);
        }
    }

    @Override
    public void addBooking() {
        bookingSet = readFile();
        Booking booking = infoBooking();
        bookingSet.add(booking);
        Map<Facility, Integer> map = facilityService.readFile(linkFacility);
        Set<Facility> facilitySet = map.keySet();
        for (Facility key : facilitySet) {
            if (key.getServiceCode().equals(booking.getServiceCode())) {
                map.replace(key, map.get(key) + 1);
            }
        }
        facilityService.writeFile(map, linkFacility);
        writeFile(bookingSet);
        System.out.println("Successfully added new!");
    }

    @Override
    public void createNewContracts() {

    }

    @Override
    public void displayListContracts() {

    }

    @Override
    public void editContracts() {

    }

    private static Booking infoBooking() {
        String codeBooking;
        while (true) {
            try {
                System.out.println("Enter CodeBooking to be corrected!");
                codeBooking = scanner.nextLine();
                FuramaCheckException.checkCode(codeBooking);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        LocalDate starDay;
        while (true) {
            try {
                System.out.println("Enter Star Day to be corrected!");
                String date = scanner.nextLine();
                FuramaCheckException.checkDate(date);
                starDay = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                FuramaCheckException.checkStartDay(starDay);
                break;
            } catch (FuramaException | DateTimeException e) {
                System.out.println(e.getMessage());
            }
        }
        LocalDate endDay;
        while (true) {
            try {
                System.out.println("Enter EndDay to be corrected!");
                String date = scanner.nextLine();
                FuramaCheckException.checkDate(date);
                endDay = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                FuramaCheckException.checkEndDay(endDay, starDay);
                break;
            } catch (DateTimeException e) {
                System.out.println("Enter incorrect format of day, re-enter");
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }

        String codeCustomer;
        customerService.displayCustomer();
        while (true) {
            try {
                System.out.println("Enter your Code to be corrected!");
                codeCustomer = scanner.nextLine();
                FuramaCheckException.checkCode(codeCustomer);
                boolean flag = false;
                for (Customer i : customerService.readFile()) {
                    if (i.getCode().equals(codeCustomer)) {
                        flag = true;
                        break;
                    }

                }
                if (flag) {
                    break;
                } else {
                    System.out.println("Code not found! Please re-enter!");
                }
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        String serviceCode;
        facilityService.displayFacility();
        while (true) {
            try {
                System.out.println("Please enter the service code you need to use!");
                serviceCode = scanner.nextLine();
                FuramaCheckException.checkServiceCode(serviceCode);
                boolean flag = false;
                Set<Facility> facilitySet = facilityService.readFile(linkFacility).keySet();
                for (Facility i : facilitySet) {
                    if (i.getServiceCode().equals(serviceCode)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                } else {
                    System.out.println("Code not found! Please re-enter!");
                }
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }

        }
        String serviceType;
        while (true) {
            try {
                System.out.println("Enter ServiceType to be corrected!");
                serviceType = scanner.nextLine();
                FuramaCheckException.checkServiceName(serviceType);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        return new Booking(codeBooking, starDay, endDay, codeCustomer, serviceCode, serviceType);
    }

    private Set<Booking> readFile() {
        Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());
        File file = new File("src/case_study_module2/data/BookingInPut.csv");
        if (!file.exists()) {
            System.out.println("File is not exist.");
        }
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            Booking booking;
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    info = line.split(",");
                    booking = new Booking();
                    booking.setCodeBooking(info[0]);
                    booking.setStartDay(LocalDate.parse(info[1], formatter));
                    booking.setEndDay(LocalDate.parse(info[2], formatter));
                    booking.setCodeCustomer(info[3]);
                    booking.setServiceCode(info[4]);
                    booking.setServiceType(info[5]);
                    bookingSet.add(booking);
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookingSet;
    }

    private void writeFile(Set<Booking> bookingSet) {
        File file = new File("src/case_study_module2/data/BookingInPut.csv");
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Booking i : bookingSet) {
                bufferedWriter.write(getInfo(i));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private String getInfo(Booking i) {
        return String.format("%s,%s,%s,%s,%s,%s", i.getCodeBooking(), i.getStartDay().format(formatter),
                i.getEndDay().format(formatter), i.getCodeCustomer(), i.getServiceCode(), i.getServiceType());
    }
}
