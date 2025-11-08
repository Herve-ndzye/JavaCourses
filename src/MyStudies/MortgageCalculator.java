package MyStudies;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    double principal;
    double interest;
    int period;

    public MortgageCalculator(double principal, double interest, int period) {
        this.principal = principal;
        this.interest = interest/100/12;
        this.period = period*12;
    }

    double getMortgage(){
        return (principal*((interest*(Math.pow(1+interest,period))/(Math.pow(1+interest,period)-1))));
    }
}
class MortgageCalculatorMain{
    public static void main(String[] args){
        Scanner c = new Scanner(System.in);
        int t;
        double p,r;
        while(true){
            System.out.print("Principal ($1k - $1M) : ");
             p = c.nextDouble();
            if(p>=1000 &&  p<=1000000)
                break;
            System.out.println("Enter a number between 1,000 and 1,000,000");
        }
            while(true){
                System.out.print("Annual Interest Rate : ");
                 r = c.nextDouble();
                if(r>0 && r<=30)
                    break;
                System.out.println("Enter a number between 1 and 30");
            }
            while(true){
                System.out.print("Period(Years) : ");
                 t = c.nextInt();
                if(t>0 && t<=30)
                    break;
                System.out.println("Enter a number between 1 and 30");
            }
            MortgageCalculator calc = new MortgageCalculator(p,r,t);
            String result = NumberFormat.getCurrencyInstance().format(calc.getMortgage());
            System.out.println("Mortgage : "+result);

    }
}
