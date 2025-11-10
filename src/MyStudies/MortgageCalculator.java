package MyStudies;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    double principal;
    double interest;
    int period;

    public MortgageCalculator(){}

    public MortgageCalculator(double principal, double interest, int period) {
        this.principal = principal;
        this.interest = interest/100/12;
        this.period = period*12;
    }
    final Scanner c = new Scanner(System.in);

    public double readInput(String prompt,int min,int max){
        double value;
        while(true){
            System.out.print(prompt);
            value = c.nextDouble();
            if(value>=min &&  value<=max)
                return value;
            System.out.println(" Enter a number between "+min+" and "+max);
        }
    }
    double getMortgage(){
        return (principal*((interest*(Math.pow(1+interest,period))/(Math.pow(1+interest,period)-1))));
    }
}
class MortgageCalculatorMain{
    public static void main(String[] args){
        MortgageCalculator calc = new MortgageCalculator();
        double p = calc.readInput(" Principal : ",1000,1000000);
        double r = calc.readInput(" Annual Interest Rate : ",1,30);
        int t = (int)calc.readInput(" Period(Years) : ",1,30);
        MortgageCalculator calculateMortgage = new MortgageCalculator(p,r,t);
        String result = NumberFormat.getCurrencyInstance().format(calculateMortgage.getMortgage());
        System.out.println(" Mortgage : "+result);
    }
}
