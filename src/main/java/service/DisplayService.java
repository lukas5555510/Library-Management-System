package service;

import model.Book;
import model.Member;
import repository.BookRepository;
import repository.MemberRepository;

public class DisplayService {
    private final BookRepository bookRepo;
    private final MemberRepository memberRepo;

    public DisplayService(BookRepository bookRepo, MemberRepository memberRepo){
        this.bookRepo = bookRepo;
        this.memberRepo = memberRepo;
    }
    public void showAllBooks(){
        if(!bookRepo.getAll().iterator().hasNext()){
            System.out.println("There is no books");
        }
        for(Book book: bookRepo.getAll()){
            System.out.println(book.toString());
        }
    }
    public void showAllMembers(){
        if(!memberRepo.getAll().iterator().hasNext()){
            System.out.println("There is no members");
        }
        for(Member member: memberRepo.getAll()){
            System.out.println(member.toString());
        }
    }
}
