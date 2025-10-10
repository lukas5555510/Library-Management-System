import jdk.nashorn.internal.runtime.ECMAException;

import java.util.HashMap;

public class Library {
    HashMap<Integer, Book> books;
    HashMap<Integer, Member> members;

    Library(){
        this.books = new HashMap<Integer, Book>();
        this.members = new HashMap<Integer, Member>();
    }
    Library(HashMap<Integer,Book> books, HashMap<Integer, Member> members){
        this.books = books;
        this.members = members;
    }

    public void addBook(int id, Book book){
        books.put(id, book);
    }

    public void addMember(int id, Member member){
        members.put(id, member);
    }

    public void borrowBook(int memberId, int bookId){
        validateBookId(bookId);
        validateMemberId(memberId);
        validateIsBookAvailable(bookId);
        books.get(bookId).setAvailable(false);
        members.get(memberId).borrowBook(books.get(bookId));
    }

    public void returnBook(int memberId, int bookId){
        validateBookId(bookId);
        validateMemberId(memberId);
        validateIfBookCanBeReturned(bookId);
        books.get(bookId).setAvailable(true);
        members.get(memberId).returnBook(books.get(bookId));
    }

    public void showAllBooks(){
        for(Book book: books.values()){
            System.out.println(book.toString());
        }
    }

    public void showAllMembers(){
        for(Member member: members.values()){
            System.out.println(member.toString());
        }
    }

    public void validateMemberId(int bookId){
        if(!books.keySet().contains(bookId)){
            throw new BookError("Wrong book id");
        }
    }

    public void validateBookId(int memberId){
        if(!members.keySet().contains(memberId)){
            throw new BookError("Wrong member id");
        }
    }

    public void validateIsBookAvailable(int bookId){
        if(books.get(bookId).getIsAvailable()==false){
            throw new BookError("Book is not available");
        }
    }
    public void validateIfBookCanBeReturned(int bookId){
        if(books.get(bookId).getIsAvailable()==true){
            throw new BookError("Book wasn't borrowed");
        }
    }
}
