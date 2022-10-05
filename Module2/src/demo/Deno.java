package demo;

import java.util.LinkedHashMap;
import java.util.Map;

public class Deno {
    int age;
    String name;
    private Object put;

    public Deno() {
    }

    public Deno(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Deno{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

}
