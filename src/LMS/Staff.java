package LMS;

public class Staff extends Person{
        public Staff(String Name,int Id){
            super(Name,Id);
        }
        public void manageBook(Book b, boolean add){
            if(add){
                b.setIsAvailable(true);
                System.out.println("The "+b.getTitle()+" book has been added.");
            }else{
                b.setIsAvailable(false);
                System.out.println("The book has been removed");
            }
        }
}
