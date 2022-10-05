package demo;

public class Deni extends Deno{
   private int height;

    public Deni() {
    }

    public Deni(int height) {
        this.height = height;
    }

    public Deni(int age, String name, int height) {
        super(age, name);
        this.height = height;
    }
}
