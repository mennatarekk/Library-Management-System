package app;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewUser {

    @FXML
    private ResourceBundle resources;

    @FXML
    private Button RemoveUserButton;

    @FXML
    private TextField RemoveUserID;

    @FXML
    private URL location;

    @FXML
    private Label UserBlockLabel;

    @FXML
    private Button registerAdd;

    @FXML
    private TextField regAddress;

    @FXML
    private TextField regEmail;

    @FXML
    private TextField regFName;

    @FXML
    private TextField regID;

    @FXML
    private TextField regLName;

    @FXML
    private TextField regNumber;

    @FXML
    private TextField regPassword;

    // @FXML
    // void addaddreader(ActionEvent event) {

    // }

    @FXML
    void initialize() {
        assert regAddress != null : "fx:id=\"regAddress\" was not injected: check your FXML file 'Register.fxml'.";
        assert regEmail != null : "fx:id=\"regEmail\" was not injected: check your FXML file 'Register.fxml'.";
        assert regFName != null : "fx:id=\"regFName\" was not injected: check your FXML file 'Register.fxml'.";
        assert regID != null : "fx:id=\"regID\" was not injected: check your FXML file 'Register.fxml'.";
        assert regLName != null : "fx:id=\"regLName\" was not injected: check your FXML file 'Register.fxml'.";
        assert regNumber != null : "fx:id=\"regNumber\" was not injected: check your FXML file 'Register.fxml'.";
        assert regPassword != null : "fx:id=\"regPassword\" was not injected: check your FXML file 'Register.fxml'.";
        assert RemoveUserButton != null : "fx:id=\"RemoveUserButton\" was not injected: check your FXML file 'Removeuser.fxml'.";
        assert RemoveUserID != null : "fx:id=\"RemoveUserID\" was not injected: check your FXML file 'Removeuser.fxml'.";


    }

    App app = new App();
    databases database = new databases();
    ArrayList <Reader> readers= (database.createArray());
    ArrayList <Librarian> librarians= (database.createArrayL());



    @FXML
    void addreaderNoswitch(ActionEvent e) throws IOException
    {
        database.copyReaders(readers);
        String type = "R", fname = regFName.getText(), lname = regLName.getText(), id = regID.getText(), email = regEmail.getText(), password= regPassword.getText(), isblocked = "no", address = regAddress.getText(), mobilenumber = regNumber.getText();
        database.addReader(readers, type, fname, lname, id, email, password, isblocked, address, mobilenumber);
        database.endReaders(readers);
        readers.clear();
        
    }
    
    @FXML
    void addlibrarianNoswitch(ActionEvent e) throws IOException
    {
        database.copyLibrarians(librarians);
        String type = "L", fname = regFName.getText(), lname = regLName.getText(), id = regID.getText(), email = regEmail.getText(), password= regPassword.getText(), isblocked = "notblocked", address = regAddress.getText(), mobilenumber = regNumber.getText();
        database.addLibrarian(librarians, type, fname, lname, id, email, password, isblocked, address, mobilenumber);
        database.endLibrarians(librarians);
        librarians.clear();
        
    
    }
    @FXML
void addreader(ActionEvent e) throws IOException
{
    database.copyReaders(readers);
    String type = "R", fname = regFName.getText(), lname = regLName.getText(), id = regID.getText(), email = regEmail.getText(), password= regPassword.getText(), isblocked = "no", address = regAddress.getText(), mobilenumber = regNumber.getText();
    database.addReader(readers, type, fname, lname, id, email, password, isblocked, address, mobilenumber);
    database.endReaders(readers);
    try {
        Parent readerpage;
        readerpage = FXMLLoader.load (getClass().getResource ("mylogin.fxml"));
        Scene readerscene = new Scene (readerpage);

        Stage appstage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        appstage.setScene (readerscene);
        appstage.show();

    } catch (IOException e1) {
        
        e1.printStackTrace();
    }
}

@FXML
void addlibrarian(ActionEvent e) throws IOException
{
    database.copyLibrarians(librarians);
    String type = "L", fname = regFName.getText(), lname = regLName.getText(), id = regID.getText(), email = regEmail.getText(), password= regPassword.getText(), isblocked = "notblocked", address = regAddress.getText(), mobilenumber = regNumber.getText();
    database.addLibrarian(librarians, type, fname, lname, id, email, password, isblocked, address, mobilenumber);
    database.endLibrarians(librarians);

    //n switch scene
    try {
        Parent readerpage;
        readerpage = FXMLLoader.load (getClass().getResource ("LibrarianLogin.fxml"));
        Scene readerscene = new Scene (readerpage);

        Stage appstage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        appstage.setScene (readerscene);
        appstage.show();

    } catch (IOException e1) {
        
        e1.printStackTrace();
    }

}

@FXML
    private TextField blockid;



    
@FXML
 void blockthis(){
    String id = blockid.getText();
    database.copyReaders(readers);
    database.blockReader(readers, id);
    readers.clear();
    UserBlockLabel.setText("User Blocked");
}
    

@FXML
    private TextField userid;


@FXML 
private Label ReaderSearchLabel;

@FXML
void userSearch(ActionEvent e){
    String id = userid.getText();
        database.copyReaders(readers);
        
        if (database.searchReader(readers, id) == null){
            ReaderSearchLabel.setText("Not Found");
        }
        else{ReaderSearchLabel.setText("Found");}

}

@FXML
private Label LibrarianSearchLabel;

@FXML
void libSearch(ActionEvent e){
    String id = userid.getText();
        database.copyLibrarians(librarians);
        
        if (database.searchLibrarian(librarians, id) == null) {

            LibrarianSearchLabel.setText("Not Found");
            
        } else {
            LibrarianSearchLabel.setText("Found");
        }
        

}


}

