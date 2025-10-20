package W3SKUL;

public class OuterClass {
    static class InnerClass{
        int y = 10;
    }
}
class main2{
    public static void main(String[] args){
        OuterClass.InnerClass inner = new OuterClass.InnerClass();
    }
}

