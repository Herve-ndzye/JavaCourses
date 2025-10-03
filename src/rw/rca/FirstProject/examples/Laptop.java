package rw.rca.FirstProject.examples;

public class Laptop {
    public void code(){
        System.out.println("Compiling using laptop");
    }
}
class Developer{
    public void compileCode(Laptop lap){
        lap.code();
    }
}
class Main{
    public static void main(String[] args){
        Laptop p =new Laptop();
        Developer dev1 = new Developer();
        dev1.compileCode(p);
    }
}
