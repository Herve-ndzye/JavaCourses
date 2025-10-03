package LMS;

public class Book {
    private String Title;
    private String Author;
    private boolean isAvailable;
    public Book(String Title, String Author) {
        this.Title = Title;
        this.Author = Author;
        this.isAvailable = true;
    }
    public String getTitle(){
        return Title;
    }
    public void setTitle(String Title){
        this.Title = Title;
    }
    public String getAuthor(){
        return Author;
    }
    public void setAuthor(String Author){
        this.Author = Author;
    }
    public boolean getIsAvailable(){
        return isAvailable;
    }
    public void setIsAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }
}

