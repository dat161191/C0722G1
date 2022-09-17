package exercise_HotelManager;

import java.util.Scanner;

public class Human {
    private String fullName;
    private String idCard;
    private String queQuan;

    public Human() {
        super();
    }

    public Human(String fullName, String queQuan, String idCard) {
        super();
        this.fullName = fullName;
        this.queQuan = queQuan;
        this.idCard = idCard;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public void inputCustomerInformation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập họ tên khách hàng: ");
        fullName = scanner.nextLine();
        System.out.print("Nhập quê quán: ");
        queQuan = scanner.nextLine();
        System.out.print("Nhập số chứng minh nhân dân: ");
        idCard = scanner.nextLine();
    }

    public void displayCustomerInformation() {
        System.out.println("Họ và tên khách hàng: " + fullName);
        System.out.println("Quê quán: " + queQuan);
        System.out.println("Số chứng minh nhân dân: " + idCard);
    }

}
