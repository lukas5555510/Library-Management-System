package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Member implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private final ArrayList<Book> borrowedBooks;

    public Member(int id, String name, ArrayList<Book> borrowedBooks){
        this.id = id;
        this.name = name;
        this.borrowedBooks = borrowedBooks;
    }

    public Member(int id, String name){
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<Book>();
    }

    // --- Domain Behavior ---
    public void borrowBook(Book book){
        borrowedBooks.add(book);
    }
    public void returnBook(Book book){
        borrowedBooks.remove(book);
    }

    // --- Getters and Setters ---
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // --- Display ---
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Member {")
                .append("id: ").append(id)
                .append(", name: ").append(name)
                .append(", books: [\n");
        for(Book book: borrowedBooks){
            sb.append(" ").append(book.toString()).append("\n");
        }
        sb.append("]}");
        return sb.toString();
    }
}
