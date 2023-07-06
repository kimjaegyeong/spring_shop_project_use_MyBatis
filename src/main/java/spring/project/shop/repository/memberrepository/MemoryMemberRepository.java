package spring.project.shop.repository.memberrepository;

import org.springframework.stereotype.Repository;
import spring.project.shop.domain.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryMemberRepository implements MemberRepository {
    private static  Map<String ,Member> memberMap = new HashMap<>();
    @Override
    public String save(Member member) {
        memberMap.put(member.getMemberId(), member);
        return member.getMemberId();
    }

    @Override
    public Member find(String id) {
        Member member = memberMap.get(id);
        return member;
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(memberMap.values());
    }

    @Override
    public String remove(Member member){
        String remove_id = member.getMemberId();
        memberMap.remove(remove_id);
        return remove_id;
    }

    @Override
    public String update(Member member) {

        memberMap.put(member.getMemberId(),member);

        return member.getMemberId();
    }
    @Override
    public void clearStore(){
        memberMap.clear();
    }

}
