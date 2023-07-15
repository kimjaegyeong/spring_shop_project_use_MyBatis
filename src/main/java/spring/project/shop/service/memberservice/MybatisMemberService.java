package spring.project.shop.service.memberservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring.project.shop.domain.Member;
import spring.project.shop.repository.memberrepository.MybatisMemberRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class MybatisMemberService implements MemberService{

    private final MybatisMemberRepository mybatisMemberRepository;
    @Override
    public String signUp(Member member) {
        //제약사항: id, pw의 길이나 특수문자 여부 등..
        //...
        mybatisMemberRepository.save(member);
        return member.getMemberId();
    }

    public String general_signUp(Member member){
        Member this_member = member;
        this_member.setGrade("general");
        mybatisMemberRepository.save(member);

        return member.getMemberId();
    }

    @Override
    public String login(String id, String password) throws NullPointerException {
        //회원여부 체크
        Member findMember = mybatisMemberRepository.find(id);
        log.debug("findMember: ",findMember);
        try {
            findMember.getMemberId();
        }catch(NullPointerException e){
            return "존재하지 않는 회원이거나 id를 잘못 입력했습니다.";
        }
        //비밀번호 일치 체크
        if(!(findMember.getPassword().equals(password))){
            return "비밀번호가 틀렸습니다.";
        }
        return findMember.getMemberId();
    }

    @Override
    public String userUpdate(Member member) {
        //아이디,비밀번호 등 필수 자료에 공란 있는지 체크
        //보통은 id가 바뀔 수 없지만, 비즈니스 원칙을 정하지 않았기 때문에 변경될 수 있는 경우도 고려함
        // 해당 member가 repository에 존재하는지 체크하는 로직 필요
        String updateMember =mybatisMemberRepository.update(member);
        return updateMember;
    }

    @Override
    public String userRemove(Member member) {
        String userId = mybatisMemberRepository.remove(member);
        return userId;
    }

    @Override
    public Member userInfo(String id){
        Member member = mybatisMemberRepository.find(id);
        return member;
    }

    public List<Member> findAll(){
        return mybatisMemberRepository.findAll();
    }

}
