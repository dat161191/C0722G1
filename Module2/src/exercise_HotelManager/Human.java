package exercise;

import java.util.Scanner;
public class Nguoi {
    private String hoTen;
    private String soCMND;
    private String queQuan;

    public Nguoi() {
        super();
    }

    public Nguoi(String hoTen, String queQuan, String soCMND) {
        super();
        this.hoTen = hoTen;
        this.queQuan = queQuan;
        this.soCMND = soCMND;
    }

    public String getSoCMND() {
        return soCMND;
    }
    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public void nhapThongTinKhachTro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập họ tên khách hàng: ");
        hoTen = scanner.nextLine();
        System.out.print("Nhập quê quán: ");
        queQuan = scanner.nextLine();
        System.out.print("Nhập số chứng minh nhân dân: ");
        soCMND = scanner.nextLine();
    }

    public void hienThiThongTinKhachTro() {
        System.out.println("Họ và tên khách hàng: " + hoTen);
        System.out.println("Quê quán: " + queQuan);
        System.out.println("Số chứng minh nhân dân: " + soCMND);
    }
}
