package controller;

import model.Book;
import model.Member;
import repository.BookRepository;
import repository.MemberRepository;
import service.DisplayService;
import service.LibraryService;
import service.ValidationService;
import util.BookError;
import util.DataFile;
import util.DataUtil;
import util.InputHandler;

import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

public class LibraryController {

    private final LibraryService libraryService;
    private final BookRepository bookRepo;
    private final MemberRepository memberRepo;
    private final DisplayService displayService;

    private static String FILE_PATH = System.getProperty("user.dir")+"/src/main/java/data/";

    public LibraryController(LibraryService libraryService, BookRepository bookRepo, MemberRepository memberRepo, DisplayService displayService){
        this.libraryService = libraryService;
        this.bookRepo = bookRepo;
        this.memberRepo = memberRepo;
        this.displayService = displayService;
    }



    public void addBook(){
        String title = InputHandler.readLine("title");
        String author = InputHandler.readLine("author");
        int id = bookRepo.getSize()+1;
        Book book = new Book(id,title,author, true);
        bookRepo.add(id, book);
        System.out.println("Book added");
    }

    public void addMember(){
        String name = InputHandler.readLine("name");
        int id = memberRepo.getSize()+1;
        Member member = new Member(id,name);
        memberRepo.add(id,member);
        System.out.println("Member added");
    }

    public void borrowBook(){
        int idBook = InputHandler.readInt("book id");
        int idMember = InputHandler.readInt("member id");
        try {
            libraryService.borrowBook(idMember,idBook);
        }catch(BookError e){
            System.out.println(e);
            System.out.println("operation stopped");
        }catch (NullPointerException e){
            System.out.println("There is no such book or member in library");
        }
        System.out.println("Book borrowed");
    }

    public void returnBook(){
        int idBook = InputHandler.readInt("book id");
        int idMember = InputHandler.readInt("member id");
        try{
            libraryService.returnBook(idMember,idBook);
        }catch(BookError e){
            System.out.println(e);
            System.out.println("operation stopped");
        }catch (NullPointerException e){
            System.out.println("There is no such book or member in library");
        }
        System.out.println("Book returned");
    }

    public void showAllMembers(){
        displayService.showAllMembers();
    }

    public void showAllBooks(){
        displayService.showAllBooks();
    }

    public void saveData(){
        System.out.println("Saving Data to file");
        int confirm = InputHandler.readInt("1 to confirm");
        if(confirm==1) {
            DataUtil.<Book>save(DataFile.BOOK.getFilename(), bookRepo.books);
            DataUtil.<Member>save(DataFile.MEMBER.getFilename(), memberRepo.members);
            System.out.println("Data saved");
        }else{
            System.out.println("Operation Canceled");
        }
    }
    public void restoreData(){
        System.out.println("Loading Data from file");
        int confirm = InputHandler.readInt("1 to confirm");
        if(confirm==1) {
            bookRepo.books = DataUtil.<Book>load(DataFile.BOOK.getFilename());
            memberRepo.members = DataUtil.<Member>load(DataFile.MEMBER.getFilename());
            System.out.println("Data restored");
        }else{
            System.out.println("Operation Canceled");
        }
    }

}
