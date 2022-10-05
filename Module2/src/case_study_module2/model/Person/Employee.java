package case_study_module2.model.Person;

import java.time.LocalDate;

public class Employee extends Person {
    private String level;
    private String position;
    private int wage;


    public Employee() {
    }

    public Employee(String level, int wage) {
        this.level = level;
        this.wage = wage;
    }

    public Employee(String Code, String fullName, LocalDate birth, String gender, String idCard, String numberPhone, String email) {
        super(Code, fullName, birth, gender, idCard, numberPhone, email);
    }

    public Employee(String Code, String fullName, LocalDate birth, String gender, String idCard, String numberPhone, String email, String level, String position, int wage) {
        super(Code, fullName, birth, gender, idCard, numberPhone, email);
        this.level = level;
        this.position = position;
        this.wage = wage;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "Employee{" +
                "level='" + level + '\'' +
                ", wage=" + wage +
                '}';
    }
}
