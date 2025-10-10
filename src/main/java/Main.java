import jdk.nashorn.internal.ir.CaseNode;

import java.util.Scanner;

public class Main {
    static Library library = new Library();

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while(option != 7){
            showOptions();
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
                case 7://exit
                    System.out.println("Exiting");
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
        System.out.println("6 - Show All Member");
        System.out.println("7 - Exit");
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
}
