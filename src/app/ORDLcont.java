package app;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ORDLcont {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button CreateList;

    @FXML
    private TextField OrderListBook;

    @FXML
    private TextField OrderListUser;

    @FXML
    void initialize() {
        assert CreateList != null : "fx:id=\"CreateList\" was not injected: check your FXML file 'BookOrderList.fxml'.";
        assert OrderListBook != null : "fx:id=\"OrderListBook\" was not injected: check your FXML file 'BookOrderList.fxml'.";
        assert OrderListUser != null : "fx:id=\"OrderListUser\" was not injected: check your FXML file 'BookOrderList.fxml'.";

    }

    databases database = new databases();
    ArrayList <AllBooks> books = (database.createArraybook());
    ArrayList <Reader> readers= (database.createArray());
    ArrayList <Librarian> librarians= (database.createArrayL());

    

    public void ordl(String id, String bid) throws IOException{

       database.copyReaders(readers);
       database.copyBooks(books);
       BookOrderList list = new BookOrderList(database.searchReader(readers, id), database.searchBook(books, bid));
       database.endBooks(books);
       books.clear();
       database.copyBooks(books);
       list.addOrder(database.searchBook(books,bid));
       System.out.println("it worked");
       database.endBooks(books);
       books.clear();
       database.endReaders(readers);
       readers.clear();
    }


    @FXML
    void ordlRemove(ActionEvent e) throws IOException{
       
        database.copyReaders(readers);
       database.copyBooks(books);
       BookOrderList list = new BookOrderList(database.searchReader(readers, OrderListUser.getText()), database.searchBook(books, OrderListBook.getText()));
       database.endBooks(books);
       books.clear();
       database.copyBooks(books);
       list.removeOrder(database.searchBook(books, OrderListBook.getText()));
       System.out.println("it worked");
       database.endBooks(books);
       books.clear();
       database.endReaders(readers);
       readers.clear();

    }

}