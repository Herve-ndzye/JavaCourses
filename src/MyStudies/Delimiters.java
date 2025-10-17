package MyStudies;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Delimiters {
    public static void main(String[] args){
        String data = "Darius ahari yashonje 1";
        String dat2 ="17-10-2025";
        Scanner c =new Scanner(data);
        Scanner d =new Scanner(dat2);
        d.useDelimiter("-");
        int num1 = d.nextInt();
        int num2= d.nextInt();
        int num3 = d.nextInt();
        System.out.println(" "+(num1+num2+num3));
        String token1 = c.next();
        String token2 = c.next();
        String token3 = c.next();
        int token4 = c.nextInt();
        System.out.println(" First: "+token1+"\n second : "+token2+"\n Third : "+token3+"\n the Fourth : "+token4);
        c.close();
    }
}
class Local{
    public static void main(String[] args){
        String data = "3,14";
        NumberFormat yen = NumberFormat.getCurrencyInstance(Locale.JAPAN);
        double amount = 2500;
        System.out.println(yen.format(amount));
        Scanner c = new Scanner(data);
        c.useLocale(java.util.Locale.FRANCE);
        double pie = c.nextDouble();
        System.out.println("Pie: "+pie);
        c.close();
    }
}
