package exercise_HotelManager;

import java.util.Scanner;

public class KhachSan {
    private int soNgayTro;
    private String loaiPhong;
    private double giaPhong;
    private Human human;
    public KhachSan() {
        super();
    }
    public KhachSan(int soNgayTro, String loaiPhong, double giaPhong, Human human) {
        super();
        this.soNgayTro = soNgayTro;
        this.loaiPhong = loaiPhong;
        this.giaPhong = giaPhong;
        this.human = human;
    }

    public Human getHuman() {
        return human;
    }
    public void setHuman(Human human) {
        this.human = human;
    }
    public void nhapThongTinCanQuanLy() {
        Scanner scanner = new Scanner(System.in);

        // nhập thông tin khách trọ
        human = new Human();
        human.nhapThongTinKhachTro();

        System.out.print("Nhập số ngày trọ: ");
        soNgayTro = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập loại phòng: ");
        loaiPhong = scanner.nextLine();
        System.out.print("Nhập giá phòng: ");
        giaPhong = scanner.nextDouble();
    }

    public void hienThiThongTinCanQuanLy() {
        human.hienThiThongTinKhachTro();
        System.out.println("Số ngày trọ: " + soNgayTro);
        System.out.println("Loại phòng: " + loaiPhong);
        System.out.println("Giá phòng: " + giaPhong);
    }
    public double tinhTien() {
        return soNgayTro * giaPhong;
    }
}
