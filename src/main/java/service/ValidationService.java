package service;

import repository.BookRepository;
import repository.MemberRepository;
import util.BookError;

public class ValidationService {
    private final BookRepository bookRepo;
    private final MemberRepository memberRepo;

    public ValidationService(BookRepository bookRepo, MemberRepository memberRepo){
        this.bookRepo = bookRepo;
        this.memberRepo = memberRepo;
    }

    public void validateMemberExist(int memberId){
        if(!memberRepo.exist(memberId)){
            throw new BookError("Wrong member id");
        }
    }

    public void validateBookExist(int bookId){
        if(!bookRepo.exist(bookId)){
            throw new BookError("Wrong book id");
        }
    }

    public void validateMemberHasBook(int memberId, int bookId){
        if(!memberRepo.get(memberId).getBorrowedBooks().contains(bookRepo.get(bookId))){
            throw new BookError("Member doesn't have that book");
        }
    }

    public void validateBookAvailable(int bookId){
        if(!bookRepo.get(bookId).isAvailable()){
            throw new BookError("Book is not available");
        }
    }

    public void validateBookCanBeReturned(int bookId){
        if(bookRepo.get(bookId).isAvailable()){
            throw new BookError("Book wasn't borrowed");
        }
    }
}
