package model;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String title;
    private String author;
    private boolean available;

    public Book(int id, String title, String author, boolean available){
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = available;
    }

    // --- Domain Behavior ---
    public void markAsBorrowed(){ this.available = false; }
    public void markAsReturned(){ this.available = true; }

    // --- Getters and Setters ---
    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailable(boolean available) { this.available = available; }
    public boolean isAvailable() { return this.available; }

    // --- Display ---
    @Override
    public String toString() {
        return "Book {"+
                "id= "+id+
                ", title= "+title+ '\''+
                ", author= "+author+'\''+
                ", available= "+ available+
                '}';
    }

}
