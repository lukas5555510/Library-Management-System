package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Member implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    ArrayList<Book> borrowedBooks;
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

    public void borrowBook(Book book){
        borrowedBooks.add(book);
    }

    public void returnBook(Book book){
        borrowedBooks.remove(book);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id: "+id+" name: ").append(name+"\n").append("books:\n");
        for(Book b: borrowedBooks){
            stringBuilder.append(b.toString()+"\n");
        }
        return stringBuilder.toString();
    }
}
