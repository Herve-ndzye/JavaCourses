package LMS;

abstract public class LibraryUser {
    protected String Name;

    protected LibraryUser(String Name){
        this.Name = Name;
    }
    abstract public void accessLibrary();
}
class StudentUser extends LibraryUser{
    public StudentUser(String Name){
        super(Name);
    }
    @Override
    public void accessLibrary(){
        System.out.println(Name+" Borrows Books!");
    }
}
class StaffUser extends LibraryUser{
    public StaffUser(String Name){
        super(Name);
    }
    @Override
    public void accessLibrary(){
        System.out.println(Name+" Manages Library!");
    }
}