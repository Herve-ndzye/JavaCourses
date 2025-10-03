package MyStudies;

public class Polymorphism {
    public int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}
class Main {
    public static void main(String[] args) {
        Polymorphism check = new Polymorphism();
        System.out.println(check.add(2, 3));
        System.out.println(check.add(3.3, (double)3.0F));
    }
}
