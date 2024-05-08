package app;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class removveee {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button RemoveUserButton;

    @FXML
    private TextField RemoveUserID;
    @FXML
    private TextField RemovebookID;
    App app = new App();
    databases database = new databases();
    ArrayList <Reader> readers= (database.createArray());
    ArrayList <Librarian> librarians= (database.createArrayL());
    ArrayList <AllBooks> books= (database.createArraybook());


    @FXML
    private Label RemoveUserLabel;

    @FXML
    void removeReader1 (ActionEvent e) throws IOException{
    System.out.println("this function has been invoked");
    database.copyReaders(readers);
    String id = RemoveUserID.getText();
    Reader ahmed = database.searchReader(readers, id);
    readers.remove(ahmed);
    database.endReaders(readers);
    readers.clear();
    
    if (ahmed == null) {
        RemoveUserLabel.setText("User not found");
        
    } else {
        RemoveUserLabel.setText("User Removed");
    }
}


@FXML
private Label RemoveBookLabel;


@FXML
    void removebook1 (ActionEvent e) throws Exception{
    System.out.println("this function has been invoked");
    database.copyBooks(books);
    String id = RemovebookID.getText();
    AllBooks booksear = database.searchBook(books, id);
    books.remove(booksear);
    database.endBooks(books);
    books.clear();
    RemoveBookLabel.setText("Book Removed");
}

    @FXML
    void initialize() {
        assert RemoveUserButton != null : "fx:id=\"RemoveUserButton\" was not injected: check your FXML file 'Removeuser.fxml'.";
        assert RemoveUserID != null : "fx:id=\"RemoveUserID\" was not injected: check your FXML file 'Removeuser.fxml'.";

    }

}
