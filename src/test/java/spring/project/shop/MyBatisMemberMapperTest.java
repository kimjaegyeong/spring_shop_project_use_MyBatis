package spring.project.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import spring.project.shop.domain.Member;
import spring.project.shop.mapper.MemberMapper;

import org.springframework.test.annotation.Rollback;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


@SpringBootTest
//@MybatisTest
@Transactional
@Rollback
public class MyBatisMemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void save(){
        Member member = new Member("u","p","여","010-1111-1212","e@e.com");
        memberMapper.save(member);

        Member findMember = memberMapper.find("u");

        Assertions.assertEquals(member.getMemberId(),findMember.getMemberId());
    }

    @Test
    public void find(){
        String id= "user1";
        Member member=memberMapper.find(id);
//        System.out.println(member.getMemberId()+ " "
//                + member.getPassword() +" "
//                +member.getGrade());
        Assertions.assertEquals(member.getMemberId(),id);
    }
    @Test
    public void findAll() {
        //MemberMapp.xml의 findall resultMap이 memberVOResultMap
        List<Member> members = memberMapper.findAll();

        
    }
}

//    @Test
//    public void findAll(){
//        //MemberMapper.xml의 findall resultType이 map
//        List<Member> members = new ArrayList<Member>();
//        List<Map<String, Object>> findMember = memberMapper.findAll();
//
//        for(Map member: findMember){
//            List<String> data =  new ArrayList<String>();
//            Iterator<String> keys = member.keySet().iterator();
//            while( keys.hasNext() ){
//                String key = keys.next();
////               System.out.println( String.format("키 : %s, 값 : %s", key, member.get(key)) );
//                data.add(String.valueOf(member.get(key)));
//            }
//            members.add(new Member(Double.parseDouble(data.get(5)),data.get(0),data.get(1),data.get(2),data.get(4),data.get(6),data.get(3)));
//        }
//
//        for(Member m : members){
//            System.out.println(m.getMemberId());
//        }
//    }

