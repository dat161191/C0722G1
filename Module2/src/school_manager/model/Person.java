package school_manager.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Person {
    private String code;
    private String name;
    private String gender;
    private LocalDate birth;
    private final DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Person(String code, String name, String gender, LocalDate birth) {
        this.code = code;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
    }

    public Person() {
    }

    public abstract String getIntroduce();

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birth='" + birth.format(fm) + '\'' +
                '}';
    }
}
