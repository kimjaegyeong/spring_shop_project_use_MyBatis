package spring.project.shop.service.memberservice;

import spring.project.shop.domain.Member;

public interface MemberService {

    public String signUp(Member member);
    public String login(String id, String password);
    public String userUpdate(Member member);
    public String userRemove(Member member);
    public Member userInfo(String id);


}