package rw.rca.FirstProject.Exercises;

public class Abstraction {
    static abstract class PaymentGateway{
        public void payment(double amount){}
    }
    class Paypal extends PaymentGateway{
        @Override
        public void payment(double amount){
            System.out.println("Processed : "+amount+" Using Paypal");
        }
    }
    class MasterCard extends PaymentGateway{
        @Override
        public void payment(double amount){
            System.out.println("Processed : "+amount+" Using MasterCard");
        }
    }
    static class MOMO extends PaymentGateway{
        @Override
        public void payment(double amount){
            System.out.println("Processed : "+amount+" Using MoMo");
        }
    }
    static class PaymentProcessor{
        public PaymentProcessor(PaymentGateway paymentGateway,double amount){
            paymentGateway.payment(amount);
        }
    }
    public static void main(String[] args){
        MOMO momo = new MOMO();
        PaymentProcessor momoProcessor = new PaymentProcessor(momo,0);
    }
}
