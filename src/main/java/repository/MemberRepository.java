package repository;

import model.Book;
import model.Member;
import java.util.HashMap;

public class MemberRepository {
    public HashMap<Integer, Member> members = new HashMap<>();

    public Member get(int id){ return members.get(id); }
    public void add(int id, Member member){ members.put(id, member);}
    public boolean exist(int id){return members.containsKey(id);}
    public Iterable<Member> getAll(){return members.values();}
    public int getSize(){return members.size();}
}
