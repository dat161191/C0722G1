package case_study_module2.service.implBookingService;

import case_study_module2.model.Booking.Booking;
import case_study_module2.service.IBookingService;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BookingService implements IBookingService {
    private static Scanner scanner=new Scanner(System.in);
    private Set<Booking> bookingSet=new TreeSet<>();
    @Override
    public void displayBooking() {

    }

    @Override
    public void addBooking() {

    }

    @Override
    public void createNewConstracts() {

    }

    @Override
    public void displayListConstracts() {

    }

    @Override
    public void editConstracts() {

    }
}
