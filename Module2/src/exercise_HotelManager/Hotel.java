package exercise_HotelManager;

import java.util.Scanner;

public class Hotel {
    private int numberOfRentalDays;
    private String typeOfRoom;
    private double roomRates;
    private Human human;
    public Hotel() {
        super();
    }
    public Hotel(int numberOfRentalDays, String typeOfRoom, double roomRates, Human human) {
        super();
        this.numberOfRentalDays = numberOfRentalDays;
        this.typeOfRoom = typeOfRoom;
        this.roomRates = roomRates;
        this.human = human;
    }

    public Human getHuman() {
        return human;
    }
    public void setHuman(Human human) {
        this.human = human;
    }
    public void inputManagementInformation() {
        Scanner scanner = new Scanner(System.in);

        // nhập thông tin khách trọ
        human = new Human();
        human.inputCustomerInformation();

        System.out.print("Nhập số ngày trọ: ");
        numberOfRentalDays = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập loại phòng: ");
        typeOfRoom = scanner.nextLine();
        System.out.print("Nhập giá phòng: ");
        roomRates = scanner.nextDouble();
    }

    public void displayManagementInformation() {
        human.displayCustomerInformation();
        System.out.println("Số ngày trọ: " + numberOfRentalDays);
        System.out.println("Loại phòng: " + typeOfRoom);
        System.out.println("Giá phòng: " + roomRates);
    }
    public double totalMoney() {
        return numberOfRentalDays * roomRates;
    }
}
