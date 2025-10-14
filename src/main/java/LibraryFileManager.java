
import java.io.*;
import java.util.HashMap;

public class LibraryFileManager {

    private static final String BOOK_FILE = "saved_books.dat";
    private static final String MEMBER_FILE = "saved_members.dat";

    public static void saveData(HashMap<Integer, Book> books, HashMap<Integer, Member> members){
        //Try(){} in those "()" we put resources that has to be closed
        try(ObjectOutputStream bookOut = new ObjectOutputStream(new FileOutputStream(BOOK_FILE));
            ObjectOutputStream memberOut = new ObjectOutputStream(new FileOutputStream(MEMBER_FILE))){

            bookOut.writeObject(books);
            memberOut.writeObject(members);

            System.out.println("Data saved");

        }catch(IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
            System.out.println(e);
        }
    }

    public static HashMap<Integer, Book> loadBooks(){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(BOOK_FILE))){
            return (HashMap<Integer, Book>) in.readObject();
        }catch (Exception e){
            System.out.println("Error loading book data: " + e.getMessage());
            return new HashMap<Integer, Book>();
        }
    }
    public static HashMap<Integer, Member> loadMembers(){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(MEMBER_FILE))){
            return (HashMap<Integer, Member>) in.readObject();
        }catch (Exception e){
            System.out.println("Error loading member data: " + e.getMessage());
            return new HashMap<Integer, Member>();
        }
    }

}
