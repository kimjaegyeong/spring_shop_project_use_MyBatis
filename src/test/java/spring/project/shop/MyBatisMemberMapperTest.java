package spring.project.shop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import spring.project.shop.domain.Member;
import spring.project.shop.mapperinterface.MemberMapper;
import java.util.Map;

@ExtendWith(SpringExtension.class)
@MybatisTest

public class MyBatisMemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void save(){

    }

    @Test
    public void find(){
        memberMapper.find("user1");
    }

}
