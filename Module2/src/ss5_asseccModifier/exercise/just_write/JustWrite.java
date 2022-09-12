package ss5_asseccModifier.exercise.just_write;

public class JustWrite {
    String name="Join";
    String classes="C02";

    public JustWrite() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "JustWrite{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }


}
