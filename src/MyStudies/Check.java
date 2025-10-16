package MyStudies;

public class Check {
    int value = 10;
}
 class check2 extends Check{
    int value = 20;
    void print(){
        System.out.println(super.value);
    }
}
class main{
    public static void main(String[] args){
        new check2().print();
    }
}