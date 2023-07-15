package spring.project.shop.repository.memberrepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring.project.shop.domain.Member;
import spring.project.shop.mapper.MemberMapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class MybatisMemberRepository implements MemberRepository{

    private final MemberMapper memberMapper;
    @Override
    public String save(Member member) {
        //제약사항: id, pw의 길이나 특수문자 여부 등..
        //...
        memberMapper.save(member);

        return member.getMemberId();
    }

    @Override
    public Member find(String id) {
        Member findMember = memberMapper.find(id);
        return findMember;
    }
    @Override
    public List<Member> findAll(){
        return memberMapper.findAll();
    }

    @Override
    public String remove(Member member) {
        memberMapper.remove(member);
        return member.getMemberId();
    }

    @Override
    public String update(Member member) {
        memberMapper.update(member);
        return member.getMemberId();
    }

    @Override
    public void clearStore() {

    }
}
