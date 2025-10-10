package MyStudies;

public class toString {
    public static void main(String[] args){
        try{
            System.out.println("The division of 12 and  0 is ");
            System.out.println(12/0);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
