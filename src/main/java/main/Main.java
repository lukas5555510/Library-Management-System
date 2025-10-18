package main;

import java.util.Scanner;
import service.*;
import util.*;
import model.*;

public class Main {
    static Library library = new Library();

    private static String FILE_PATH = System.getProperty("user.dir")+"/src/main/java/data/";

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        boolean showOptions = true;
        while(option != 9){
            if(showOptions) {
                showOptions();
            }
            String input = scanner.nextLine();
            if(input.equals("")){
                input = "0";
            }
            try {
                option = Integer.parseInt(input);
            }catch(NumberFormatException e){
                System.out.println("catched bad input, fixing it");
                option = 99;
            }



            switch (option){
                case 1:
                    addBook();
                    break;
                case 2:
                    addMember();
                    break;
                case 3://borrow book
                    borrowBook();
                    break;
                case 4://return book
                    returnBook();
                    break;
                case 5://show all books
                    showAllBooks();
                    break;
                case 6://show all members
                    showAllMembers();
                    break;
                case 7://save data
                    saveData();
                    break;
                case 8://load data
                    restoreData();
                    break;
                case 9://exit
                    System.out.println("Exiting");
                    break;
                case 10://show Menu on/off
                    if(showOptions){
                        showOptions = false;
                        System.out.println("Showing Options OFF");
                    }else{
                        showOptions = true;
                        System.out.println("Showing Options ON");
                    }

                    break;
                default:
                    System.out.println("Incorrect option");
                    break;
            }
        }
    }
    public static void showOptions(){
        System.out.println("1 - Add Book");
        System.out.println("2 - Add Member");
        System.out.println("3 - Borrow Book");
        System.out.println("4 - Return Book");
        System.out.println("5 - Show All Books");
        System.out.println("6 - Show All Members");
        System.out.println("7 - Save data to file");
        System.out.println("8 - Restore data from file");
        System.out.println("9 - Exit");
        System.out.println("10 - Show options ON/OFF");
    }

    public static void addBook(){
        System.out.println("Adding book");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write title");
        String title = scanner.nextLine();
        System.out.println("Write author");
        String author = scanner.nextLine();
        Book book = new Book(library.books.size()+1,title,author, true);
        library.addBook(library.books.size()+1,book);
    }

    public static void addMember(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write name");
        String name = scanner.nextLine();
        Member member = new Member(library.members.size()+1,name);
        library.addMember(library.members.size()+1,member);
    }

    public static void borrowBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write member id");
        int idMember = Integer.parseInt(scanner.nextLine());
        System.out.println("Write book id");
        int idBook = Integer.parseInt(scanner.nextLine());
        try {
            library.borrowBook(idMember, idBook);
        }catch(BookError e){
            System.out.println(e);
            System.out.println("operation stopped");
        }catch (NullPointerException e){
            System.out.println("There is no such book or member in library");
        }
    }

    public static void returnBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write member id");
        int idMember = Integer.parseInt(scanner.nextLine());
        System.out.println("Write book id");
        int idBook = Integer.parseInt(scanner.nextLine());
        try{
        library.returnBook(idMember,idBook);
        }catch(BookError e){
            System.out.println(e);
            System.out.println("operation stopped");
        }catch (NullPointerException e){
            System.out.println("There is no such book or member in library");
        }
    }

    public static void showAllMembers(){
        library.showAllMembers();
    }

    public static void showAllBooks(){
        library.showAllBooks();
    }

    public static void saveData(){
        System.out.println("Saving Data to file");
        DataLoader.save(FILE_PATH ,DataFile.BOOK.getFilename(), library.books);
        DataLoader.save(FILE_PATH, DataFile.MEMBER.getFilename(), library.members);
    }
    public static void restoreData(){
        System.out.println("Loading Data from file");
        library.books = DataLoader.load(FILE_PATH, DataFile.BOOK.getFilename());
        library.members = DataLoader.load(FILE_PATH, DataFile.MEMBER.getFilename());
    }
}
