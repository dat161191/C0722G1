package case_study;

class Person {
    int id;
    String name;
    Person (int id, String name){
        this.id = id;
        this.name = name;
    }
}

class Emp extends Person{
    float salary;
    Emp (int id, String name, float salary){
        //gọi lại constructor có 2 tham số là id và name của class cha
        super(id, name);
        this.salary = salary;
    }
    void display(){
        System.out.println(id + " " + name + " " + salary);
    }
}

class SuperInJava {
    public static void main(String[] args) {
        Emp e1 = new Emp(1, "ankit", 45000f);
        e1.display();
    }
}