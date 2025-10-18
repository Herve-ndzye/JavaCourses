package MyStudies;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class printThree {
    public static void main(String[] args){
        System.out.printf("%-5s %-5s %-5s %n",10,20,30);
    }
}
class pie{
    public static void main(String[] args){
        double PI = Math.PI;
        System.out.printf("%5.2f%n %.4f%n %.6f%n",PI,PI,PI);
    }
}
class Names{
    public static void main(String[] args){
        System.out.printf("|%-6s|%5s|%n","Herve",93);
        System.out.printf("|%-5s|%5s|","Tresor",93);
    }
}
class moneyFormatter{
    public static void main(String[] args){
        int money = 1200000;
        NumberFormat thousands = NumberFormat.getInstance();
        String result = thousands.format(money);
        System.out.println(result);
        System.out.printf(Locale.US,"%,d%n",money);
        System.out.printf(Locale.FRANCE,"%,d",money);
    }
}
class currencies{
    public static void main(String[] args){
        double money = 1999.99;
        NumberFormat dollar = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println(dollar.format(money));
        NumberFormat eur = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        System.out.println(eur.format(money));
        NumberFormat yen = NumberFormat.getCurrencyInstance(Locale.JAPAN);
        System.out.println(yen.format(money));
    }
}
class field{
    public static void main(String[] args){
        System.out.printf("%+08.2f",123.45);
    }
}
class productTable{
    public static void main(String[] args){
        System.out.println("        Product Table");
        System.out.println("----------------------------");
        System.out.printf("|  %-6s|  %-5s|  %-7s|%n","Name","Qty","Price");
        System.out.println("----------------------------");
    }
}
class Locales{
    public static void main(String[] args){
        Scanner c = new Scanner(System.in);
        double num ;
        c.useLocale(java.util.Locale.FRANCE);
        num = c.nextDouble();
        NumberFormat dot = NumberFormat.getInstance(Locale.US);
        System.out.println(dot.format(num));
    }
}
class date{
    public static void main(String[] args){
        Date now = new Date();
        System.out.printf(Locale.US,"%tc%n",now);
        System.out.printf(Locale.FRANCE,"%tc%n",now);
    }
}