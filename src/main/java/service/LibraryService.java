package service;

import model.Book;
import model.Member;
import repository.BookRepository;
import repository.MemberRepository;

public class LibraryService {
    private final ValidationService validator;
    private final BookRepository bookRepo;
    private final MemberRepository memberRepo;

    public LibraryService(ValidationService validator, BookRepository bookRepo, MemberRepository memberRepo){
        this.validator = validator;
        this.bookRepo = bookRepo;
        this.memberRepo = memberRepo;
    }

    public void borrowBook(int memberId, int bookId){
        validator.validateBookExist(bookId);
        validator.validateMemberExist(memberId);
        validator.validateBookAvailable(bookId);

        Book book = bookRepo.get(bookId);
        Member member = memberRepo.get(memberId);

        book.markAsBorrowed();
        member.borrowBook(book);
    }

    public void returnBook(int memberId, int bookId){
        validator.validateBookExist(bookId);
        validator.validateMemberExist(memberId);
        validator.validateBookCanBeReturned(bookId);
        validator.validateMemberHasBook(memberId, bookId);

        Book book = bookRepo.get(bookId);
        Member member = memberRepo.get(memberId);

        book.markAsReturned();
        member.returnBook(book);
    }
}
