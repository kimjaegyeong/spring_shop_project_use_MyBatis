package spring.project.shop;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.project.shop.domain.Member;
import spring.project.shop.repository.memberrepository.MemoryMemberRepository;

import java.util.List;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository mr = new MemoryMemberRepository();

    @BeforeEach
    public void BeforeEach(){ mr.clearStore();}

    @Test
    void 메모리_저장_테스트(){
        //given
        Member member = new Member();
        member.setMemberId("test1");
        member.setPassword("test12");
        member.setGrade("Common");
        member.setEmail("test@test.com");
        member.setGender("남");
        member.setPhoneNumber("010-0000-0000");
        //when
        String save_id = mr.save(member);
        //then
        Assertions.assertEquals(member.getMemberId(),save_id);

    }

    @Test
    void 단일_멤버_검색_테스트(){
        //given
        Member member1= new Member();
        member1.setMemberId("test1");
        mr.save(member1);

        Member member2= new Member();
        member2.setMemberId("test1");
        mr.save(member2);
        //when
        Member findMember =mr.find(member1.getMemberId());
        //then
        Assertions.assertEquals(member1.getMemberId(), findMember.getMemberId());

    }

    @Test
    void 전체_멤버_검색_테스트(){
        //given
        Member member1= new Member();
        member1.setMemberId("test1");
        mr.save(member1);

        Member member2= new Member();
        member2.setMemberId("test2");
        mr.save(member2);
        //when
        List<Member> memberList = mr.findAll();
        //then
        Assertions.assertEquals(memberList.size(),2);
    }

    @Test
    void 멤버_업데이트_테스트(){
        //given
        Member member = new Member();
        member.setMemberId("test1");
        member.setPassword("test12");
        member.setGrade("Common");
        member.setEmail("test@test.com");
        member.setGender("남");
        member.setPhoneNumber("010-0000-0000");
        mr.save(member);
        String beforeGrade = mr.find(member.getMemberId()).getGrade();

        Member member1 = new Member();
        member1.setMemberId("test1");
        member1.setPassword("test123");
        member1.setGrade("Admin");
        member1.setEmail("test@test.com");
        member1.setGender("남");
        member1.setPhoneNumber("010-0000-0000");

        //when
        String afterId = mr.update(member1);
        String afterGrade = mr.find(member1.getMemberId()).getGrade();
        //then
        Assertions.assertNotEquals(beforeGrade, afterGrade);

    }

    @Test
    void 멤버삭제_테스트(){
        //given
        Member member= new Member();
        member.setMemberId("test1");
        mr.save(member);
        //when
        mr.remove(member);
        //then
        Assertions.assertNull(mr.find(member.getMemberId()));


    }
}
