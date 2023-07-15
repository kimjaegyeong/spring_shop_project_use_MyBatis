package spring.project.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import spring.project.shop.domain.Member;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {

    public void save(Member member);

    public Member find(String id);

    public List<Member> findAll();

    public void remove(Member member);

    public void update(Member member);

}
