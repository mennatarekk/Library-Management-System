package app;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Bookfuncs {
    


    @FXML
    private TextField bookid;

    
    databases database = new databases();
    ArrayList <AllBooks> books = (database.createArraybook());
    ArrayList <Reader> readers= (database.createArray());
    ArrayList <Librarian> librarians= (database.createArrayL());
    ORDLcont ordl = new ORDLcont();

    @FXML
    private TextField rentid;

    @FXML
    private TextField rentuserid;

    @FXML
    private TextField bookauthor;

    @FXML
    private Label bookrentedlabel;

    @FXML
    private Label BookSearchLabel;

    @FXML
    private Label AddBookLabel;
    

    @FXML
    private TextField booktitle;

    @FXML
    private TextField rentTitle;

    @FXML
    void rentthis() throws Exception{

    
        String id = rentuserid.getText();
        String titleb = rentTitle.getText();
        database.copyReaders(readers);
        database.copyBooks(books);
        AllBooks booki = database.rent(books, titleb, id, readers);
        database.endBooks(books);
        books.clear();
        database.endReaders(readers);
        readers.clear();


        if (booki != null) {
            bookrentedlabel.setText("Book Rented");
            ordl.ordl(id, titleb);
        } else {
            bookrentedlabel.setText("Book Rental Failed");
        }
        
    }



    @FXML
    void addbookss(ActionEvent e) throws Exception
    {
        database.copyBooks(books);
        String title = booktitle.getText() , author = bookauthor.getText() , id = bookid.getText();
        database.addBooks(books, title, author, id );
        database.endBooks(books);
        books.clear();
        AddBookLabel.setText("Book Added <3");

    }


    @FXML

    void searchforBook(ActionEvent e) throws Exception {
        String title = bookid.getText();
        database.copyBooks(books);
        AllBooks book = database.searchBook(books, title);
        database.endBooks(books);
        books.clear();
        if (book == null) {

            BookSearchLabel.setText("Book Not Found");
            
        } else {
            BookSearchLabel.setText("Book Found");
 
        }
    }
}
