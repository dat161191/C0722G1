package school_manager.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AccountBank extends Person {
    private String nameClass;
    private double score;
    private DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public AccountBank(String code, String name, String gender, LocalDate birth, String nameClass, double score) {
        super(code, name, gender, birth);
        this.nameClass = nameClass;
        this.score = score;
    }

    public AccountBank(String nameClass, double score) {
        this.nameClass = nameClass;
        this.score = score;
    }

    public AccountBank() {
    }

    @Override
    public String getIntroduce() {
        return "Tôi là Học Sinh";
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return this.getIntroduce() + ": " + String.format("%s,%s,%s,%s,%s,%s", this.getCode(), this.getName(), this.getGender(), this.getBirth().format(fm), this.getNameClass(), this.getScore());
    }
}
