package MyStudies;
import java.util.Scanner;

public class Exceptions extends Throwable {
    public static  int division(int a, int b) throws ArithmeticException {
        return a / b;
    }

    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);
        System.out.println("Enter the first number:");
        int a = c.nextInt();
        System.out.println("Enter the second number");
        int b = c.nextInt();

        try {
            System.out.println("The result is "+division(a,b));
        } catch (ArithmeticException e) {
            System.out.println(e);
            e.printStackTrace();
        }

    }
}
