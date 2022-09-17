package ss5_asseccModifier.pratice;

public class Student {
    private int rollno;
    private String name;
    private static String college = "BBDIT";

    Student(int r, String n) {
        rollno = r;
        name = n;
    }

    Student() {
        college = "CodeGym";
    }

    static void change() {
        college = "CodeGym";
        System.out.println(college);
    }

    //    public String getChange() {
//        return college = "CODEGYM";
//    }
    void display() {
        System.out.println(rollno + " " + name + " " + college);
    }

    public static void main(String[] args) {
        Student s1 = new Student(111, "Hoang");
        Student s2 = new Student(222, "Khanh");
        Student s3 = new Student(333, "Nam");
        Student s4 = new Student();
//        Student.change();
//        s1.getChange();
        s1.display();
        s2.display();
        s3.display();

    }
}

