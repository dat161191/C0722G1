package model;

public class PhongTro {
    private int maPhongTro;
    private String ten;
    private String sdt;
    private String ngayThue;
    private String ghiChu;
    private String email;
    private int maThanhToan;
    private String tenHinhThuc;

    public PhongTro(int maPhongTro, String ten, String sdt, String ngayThue, String ghiChu, String email, int maThanhToan, String tenHinhThuc) {
        this.maPhongTro = maPhongTro;
        this.ten = ten;
        this.sdt = sdt;
        this.ngayThue = ngayThue;
        this.ghiChu = ghiChu;
        this.email = email;
        this.maThanhToan = maThanhToan;
        this.tenHinhThuc = tenHinhThuc;
    }

    public PhongTro(String ten, String sdt, String ngayThue, String ghiChu, String email, int maThanhToan) {
        this.ten = ten;
        this.sdt = sdt;
        this.ngayThue = ngayThue;
        this.ghiChu = ghiChu;
        this.email = email;
        this.maThanhToan = maThanhToan;
    }

    public PhongTro(int maPhongTro, String ten, String sdt, String ngayThue, String ghiChu, String email, int maThanhToan) {
        this.maPhongTro = maPhongTro;
        this.ten = ten;
        this.sdt = sdt;
        this.ngayThue = ngayThue;
        this.ghiChu = ghiChu;
        this.email = email;
        this.maThanhToan = maThanhToan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMaPhongTro() {
        return maPhongTro;
    }

    public void setMaPhongTro(int maPhongTro) {
        this.maPhongTro = maPhongTro;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(String ngayThue) {
        this.ngayThue = ngayThue;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getMaThanhToan() {
        return maThanhToan;
    }

    public void setMaThanhToan(int maThanhToan) {
        this.maThanhToan = maThanhToan;
    }

    public String getTenHinhThuc() {
        return tenHinhThuc;
    }

    public void setTenHinhThuc(String tenHinhThuc) {
        this.tenHinhThuc = tenHinhThuc;
    }
}
