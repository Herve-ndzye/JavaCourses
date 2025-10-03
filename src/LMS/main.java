package LMS;

public class main {
        public static void main(String[] args){
            Book Math = new Book("Mathematics","Happy David");
            Math.setTitle("A Level Mathematics Book");
            Math.setAuthor("Niyonkuru Darius");
            Math.setIsAvailable(false);
            System.out.println("The book title is "+Math.getTitle());
            System.out.println("The author is "+Math.getAuthor());
            System.out.println("The book availability is "+Math.getIsAvailable());
            Student s = new Student("Herve",100,"Robotics");
            System.out.println(s.Name);
            System.out.println(s.Id);
            System.out.println(s.department);

            Person Aloys = new Student("Aloys",100,"Backend");
            Person Herve = new Staff("Herve",99);

            ((Student)Aloys).borrowBook(Math);
            ((Staff)Herve).manageBook(Math,true);

            StudentUser Su = new StudentUser(Aloys.Name);
            StaffUser SA = new StaffUser(Herve.Name);
            Su.accessLibrary();
            SA.accessLibrary();

            Book Eng = new Book("English","Muhizi Brian");
            Book SE = new Book("SE","Mulindwa Christian");
            Student s1 = new Student("Tresor",123,"SideJobs");
            Staff st = new Staff("Isaac",1);
            s1.borrowBook(Eng);

        }
}
