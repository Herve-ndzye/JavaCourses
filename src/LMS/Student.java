package LMS;

public class Student extends Person{
        public String department;
        public Student(String Name,int Id,String department){
            super(Name,Id);
            this.department = department;
        }
        public void borrowBook(Book b){
            if(b.getIsAvailable()) {
                System.out.println("Yes");
                b.setIsAvailable(false);
            }
            else System.out.println("No");
        }
    public void returnBook(Book b) {
        b.setIsAvailable(true);
        System.out.println(Name + " returned: " + b.getTitle());
    }
}

