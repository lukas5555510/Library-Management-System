package repository;

import model.Book;

import java.util.HashMap;

public class BookRepository {
    public HashMap<Integer, Book> books = new HashMap<>();

    public Book get(int id){ return books.get(id); }
    public void add(int id, Book book){ books.put(id, book);}
    public boolean exist(int id){return books.containsKey(id);}
    public Iterable<Book> getAll(){return books.values();}
    public int getSize(){return books.size();}
}
