package school_manager.model;

public class Teacher extends Person {
    private String technique;

    public Teacher(String technique) {
        this.technique = technique;
    }

    public Teacher() {
    }

    public Teacher(String code, String name, String gender, String birth, String technique) {
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
        return String.format("%s,%s,%s,%s,%s", this.getCode(), this.getName(), this.getGender(), this.getBirth(), this.getTechnique());
    }

}
