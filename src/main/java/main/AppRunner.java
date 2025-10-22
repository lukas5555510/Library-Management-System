package main;

import controller.LibraryController;
import repository.BookRepository;
import repository.MemberRepository;
import service.DisplayService;
import service.LibraryService;
import service.ValidationService;
import ui.ConsoleMenu;
import util.InputHandler;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Scanner;

public class AppRunner {
    private BookRepository bookRepository = new BookRepository();
    private MemberRepository memberRepository = new MemberRepository();
    private ValidationService validationService = new ValidationService(bookRepository,memberRepository);
    private LibraryService libraryService = new LibraryService(validationService,bookRepository,memberRepository);
    private DisplayService displayService = new DisplayService(bookRepository,memberRepository);
    private LibraryController libraryController = new LibraryController(libraryService,bookRepository,memberRepository,displayService);


    public void run() {
        boolean running = true;
        boolean showOptions = false;
        while (running) {
            System.out.println("Choose Option");
            if (showOptions) {
                ConsoleMenu.showOptions();
            }
            int option = InputHandler.readInt();
            switch (option) {
                case 1 -> libraryController.addBook();
                case 2 -> libraryController.addMember();
                case 3 -> libraryController.borrowBook();
                case 4 -> libraryController.returnBook();
                case 5 -> libraryController.showAllBooks();
                case 6 -> libraryController.showAllMembers();
                case 7 -> libraryController.saveData();
                case 8 -> libraryController.restoreData();
                case 9 -> running = false;
                case 10 -> showOptions = !showOptions;
                case 11 -> ConsoleMenu.showOptions();
                default -> System.out.println("Invalid Option, Try again");
            }
        }
    }
}
