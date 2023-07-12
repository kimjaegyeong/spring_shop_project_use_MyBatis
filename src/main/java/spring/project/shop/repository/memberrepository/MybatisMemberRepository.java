package spring.project.shop.repository.memberrepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.project.shop.domain.Member;
import spring.project.shop.mapperinterface.MemberMapper;

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
    public List<Member> findAll() {
        List<Map<String,Object>> findMember = memberMapper.findAll();

        showAllFindMember(findMember);

        return null;
    }

    private static void showAllFindMember(List<Map<String, Object>> findMember) {
        for(Map member: findMember){
            Iterator<String> keys = member.keySet().iterator();
            while( keys.hasNext() ){
                String key = keys.next();
                System.out.println( String.format("키 : %s, 값 : %s", key, member.get(key)) );
            }
            System.out.println("");
        }
    }

    @Override
    public String remove(Member member) {
        String userId = memberMapper.remove(member);
        return userId;
    }

    @Override
    public String update(Member member) {
        String updateMember =memberMapper.update(member);
        return updateMember;
    }

    @Override
    public void clearStore() {

    }
}
