package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

import javafx.fxml.FXML;

public class databases {

    @FXML
  
    Scanner scanner = new Scanner(System.in);

void copyReaders(ArrayList<Reader> readers) {
    try {
        Scanner scanner = new Scanner(new File("data/Readers.txt"));
        while (scanner.hasNextLine()) {
            int i=0;
            String[] line = scanner.nextLine().split(",");
            String type = line[i].trim();
            String firstName = line[i+1].trim();
            String lastname = line[i+2].trim();
            String id = line[i+3].trim();
            String email = line[i+4].trim();
            String password = line[i+5].trim();
            String isblocked = line[i+6].trim();
            String address = line[i+7].trim();
            String mobilenumber = line[i+8].trim();
            Reader human = new Reader(type, firstName, lastname, id, email, password, isblocked, address, mobilenumber);
            readers.add(human);
            i= i+9;
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        System.out.println("File not found!");
    }


    for (Reader human : readers) {
        System.out.println(human);
      }
    }

void copyLibrarians(ArrayList<Librarian> librarians) {
        try {
            Scanner scanner = new Scanner(new File("data/Librarians.txt"));
            while (scanner.hasNextLine()) {
                int i=0;
                String[] line = scanner.nextLine().split(",");
                String type = line[i].trim();
                String firstName = line[i+1].trim();
                String lastname = line[i+2].trim();
                String id = line[i+3].trim();
                String email = line[i+4].trim();
                String password = line[i+5].trim();
                String isblocked = line[i+6].trim();
                String address = line[i+7].trim();
                String mobilenumber = line[i+8].trim();
                Librarian human = new Librarian(type, firstName, lastname, id, email, password, 
                                                isblocked, address, mobilenumber);
                librarians.add(human);
                i= i+9;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    
    
        for (Librarian human : librarians) {
            System.out.println(human);
          }
        }


void copyBooks(ArrayList<AllBooks> books) {
            try {
                Scanner scanner = new Scanner(new File("data/Books.txt"));
                while (scanner.hasNextLine()) {
                    String[] line = scanner.nextLine().split(",");
                    if (line.length >= 4) { // Check if the array has enough elements
                        String title = line[0].trim();
                        String author = line[1].trim();
                        String id = line[2].trim();
                        String isAvailable = line[3].trim();
                        AllBooks book = new AllBooks(title, author, id, isAvailable);
                        books.add(book);
                    } else {
                        // Handle the case when the line doesn't have enough elements
                        System.out.println("Invalid line format: " + Arrays.toString(line));
                    }
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }
        
            for (AllBooks book : books) {
                System.out.println(book);
            }
        
            try {
                FileWriter writer = new FileWriter("data/Books.txt");
                writer.write(""); // Write an empty string to clear the file
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        
        }
        

void addReader(ArrayList<Reader> readers, String type , String fname, String lname, String id,
                        String email, String password, String isblocked, String address, String mobilenumber) {
    
   
    System.out.println("enter the data for a new reader");
    Reader newReader = new Reader(type, fname, lname, id, email, password, isblocked, address, mobilenumber);
    readers.add(newReader);
    System.out.println(newReader);
   
}

void blockReader(ArrayList<Reader> readers, String id){
     
    try {
        Reader humantest;
     humantest = searchReader(readers, id);
    
    if( humantest != null){

    humantest.setIsBlocked("Blocked");
    }
        endReaders(readers);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    

}

void addLibrarian(ArrayList<Librarian> librarians, String type , String fname, 
    String lname, String id, String email, String password, String isblocked, String address, String mobilenumber) {
    
   
    System.out.println("enter the data for a new reader");
    Librarian newLibrarian = new Librarian(type, fname, lname, id, email, password, isblocked, address, mobilenumber);
    librarians.add(newLibrarian);
    System.out.println(newLibrarian);
   
}

void addBooks (ArrayList <AllBooks> books, String title, String author, String Id)
{
    System.out.println("enter the data for a new book");
    AllBooks newBook = new AllBooks(title, author, Id, "Available");
    books.add(newBook);
    System.out.println(newBook);
}

Reader searchReader(ArrayList<Reader> readers, String id){

    for (Reader human : readers) {
        if (human.getID().equals(id)) {
            System.out.println("User found");
            return human;
        }
    }
    System.out.println("User not found!");
    return null;
}

AllBooks searchBook(ArrayList<AllBooks> boooks, String title){

    for (AllBooks book : boooks) {
        if (book.getTitle().equals(title)) {
            System.out.println("Book found");
            return book;
        }
    }
    System.out.println("Book not found!");
    return null;
}

Librarian searchLibrarian(ArrayList<Librarian> librarians, String id){

    for (Librarian human : librarians) {
        if (human.getID().equals(id)) {
            System.out.println("User found");
            return human;
        }
    }
    System.out.println("User not found!");
    return null;
}



Reader loginReader(ArrayList<Reader> readers, String id, String password){

    for (Reader human : readers) {
        if (human.getID().equals(id) && human.getPassword().equals(password)) {
            System.out.println("User found");
            return human;
        }
    }
    System.out.println("User not found!");
    return null;
}

Librarian loginLibrarian(ArrayList<Librarian> librarian, String id, String password){
    
    for (Librarian human : librarian) {
        if (human.getID().equals(id) && human.getPassword().equals(password)) {
            System.out.println("User found");
            
            return human;
        }
    }
    System.out.println("User not found!");
    return null;
}

void endReaders(ArrayList<Reader> readers) throws IOException{
    
    try {
        FileWriter writer = new FileWriter("data/Readers.txt", false);
    
        for (Reader human : readers) {
            writer.write(human.toString() + "\n");
        }
    
        writer.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }

}

void endLibrarians(ArrayList<Librarian> librarians) throws IOException{
    
    try {
        FileWriter writer = new FileWriter("data/Librarians.txt", false);
    
        for (Librarian librarian : librarians) {
            writer.write(librarian.toString() + "\n");
        }
    
        writer.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }

}

void endBooks(ArrayList<AllBooks> books) throws IOException{
    
    try {
        FileWriter writer = new FileWriter("data/Books.txt", false);
    
        for (AllBooks book : books) {
            writer.write(book.toString() + "\n");
        }
    
        writer.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }

}

ArrayList<Reader> createArray(){
    ArrayList<Reader> readers = new ArrayList<>();
    System.out.println("array done");
    return readers;
}

ArrayList<Librarian> createArrayL(){
    ArrayList<Librarian> librarians = new ArrayList<>();
    System.out.println("arrayL done");
    return librarians;
}

ArrayList<AllBooks> createArraybook(){
    ArrayList<AllBooks> books = new ArrayList<>();
    System.out.println("arraybook done");
    return books;
}



public void removeReader(ArrayList<Reader> readers, String id) {
    
    readers.remove(searchReader(readers, id));
    System.out.println("User has been removed");
}

public void removeBook(ArrayList<AllBooks> books, String id) {
    
    books.remove(searchBook(books, id));
    System.out.println("Book has been removed");
}

AllBooks rent(ArrayList<AllBooks> books, String title, String id, ArrayList<Reader> readers) throws Exception{


    Reader reader = searchReader(readers, id);
    if ( reader != null) {
    
        for (AllBooks book : books) {
            try {
                if (book.getTitle().equals(title)) {
                    if (book.getIsAvailable().equals("Available")) {
                    book.setIsAvailable("Rented");
                    System.out.println("Book " + title + " has been rented.");
                    
                    return book;
                } 
                else {
                System.out.println("Book" + title + " is already rented.");
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
    System.out.println("Book " + title + " is not available in the library.");
}
    else
        {System.out.println("Cant rent, incorrectid");
        }

return null;
}


}


