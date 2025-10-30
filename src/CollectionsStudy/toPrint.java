package CollectionsStudy;

public class toPrint<T> {
    T value;
    public toPrint(T value){
        this.value = value;
    }
    public void display(){
        System.out.println("The value is : "+this.value);
    }
}
class Main{
    public static <T,S> T displayAll(T val1, S val2){
        return val1;
    }
    public static void main(String[] args){
        toPrint<Integer> printer = new toPrint<>(10);
        printer.display();
        System.out.println("The first value is : "+displayAll(1,"Hey"));
    }
}
