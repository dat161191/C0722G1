package thi_module2.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class AccountBank {
    private int iD;
    private int code;
    private String name;
    private LocalDate dateCreate;
    private DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public abstract String getIntroduce();

    public AccountBank(int iD, int code, String name, LocalDate dateCreate) {
        this.iD = iD;
        this.code = code;
        this.name = name;
        this.dateCreate = dateCreate;
    }

    public AccountBank() {
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "iD='" + iD + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", dateCreate=" + dateCreate.format(format) +
                '}';
    }
}
