package school_manager.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.zip.DataFormatException;

public class Teacher extends Person {
    private String technique;
    private DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Teacher(String technique) {
        this.technique = technique;
    }

    public Teacher() {
    }

    @Override
    public String getIntroduce() {
        return "Tôi là Giáo Viên";
    }


    public Teacher(String code, String name, String gender, LocalDate birth, String technique) {
        super(code, name, gender, birth);
        this.technique = technique;
    }

    public String getTechnique() {
        return technique;
    }

    public void setTechnique(String technique) {
        this.technique = technique;
    }

    @Override
    public String toString() {
        return this.getIntroduce()+": "+String.format("%s,%s,%s,%s,%s", this.getCode(), this.getName(), this.getGender(), this.getBirth().format(fm), this.getTechnique());
    }
}
