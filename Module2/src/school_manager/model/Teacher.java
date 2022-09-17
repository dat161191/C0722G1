package school_manager.model;

public class Teacher extends Person {
    private String technique;

    public Teacher(String technique) {
        this.technique = technique;
    }

    public Teacher() {
    }

    public Teacher(String code, String name, String gender, String technique) {
        super(code, name, gender);
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
        return "Teacher{" +
                "technique='" + technique + '\'' +
                '}'+super.toString();
    }

}
