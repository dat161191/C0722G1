package case_study_module2.model;

public class Employee extends Person {
    private String level;
    private double wage;

    public Employee() {
    }

    public Employee(String level, double wage) {
        this.level = level;
        this.wage = wage;
    }

    public Employee(String Code, String fullName, String birth, String gender, int idCard, int numberPhone, String email) {
        super(Code, fullName, birth, gender, idCard, numberPhone, email);
    }

    public Employee(String Code, String fullName, String birth, String gender,
                    int idCard, int numberPhone, String email, String level, double wage) {
        super(Code, fullName, birth, gender, idCard, numberPhone, email);
        this.level = level;
        this.wage = wage;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "level='" + level + '\'' +
                ", wage=" + wage +
                '}' + super.toString();
    }
}
