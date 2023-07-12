package spring.project.shop.mapperinterface;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import spring.project.shop.domain.Member;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {

    public void save(Member member);

    public Member find(String id);

    public List<Map<String,Object>> findAll();

    public String remove(Member member);

    public String update(Member member);

}
