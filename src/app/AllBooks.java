package app;

public class AllBooks {
    private String title;
    private String Author;
    private String ID;
    private String isAvailable;
   
    

    public AllBooks(String title, String author, String iD, String isAvailable) {
        this.title = title;
        Author = author;
        ID = iD;
        this.isAvailable = isAvailable;
    } 

    
    
   
    public String getID() {
        return ID;
    }




    public void setID(String iD) {
        ID = iD;
    }




    public String getTitle() {
        return title;
    }

    public String getIsAvailable() {
        return isAvailable;
    }




    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }




    @Override
    public String toString() {
        return title + ", " + Author + ", "+ ID + ", " + isAvailable+ ",";
    }




}