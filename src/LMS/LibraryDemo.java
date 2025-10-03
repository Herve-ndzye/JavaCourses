package LMS;

public class LibraryDemo {
    public static void main(String[] args){
        Book Eng = new Book("English","Muhizi Brian");
        Book SE = new Book("SE","Mulindwa Christian");
        Student s1 = new Student("Tresor",123,"SideJobs");
        Staff st = new Staff("Isaac",1);
        s1.borrowBook(Eng);
        s1.returnBook(Eng);
        StudentUser SUser = new StudentUser(s1.Name);
        StaffUser SAUser = new StaffUser(st.Name);
        st.manageBook(SE,false);
        st.manageBook(SE,true);
        SUser.accessLibrary();
        SAUser.accessLibrary();
    }
}
