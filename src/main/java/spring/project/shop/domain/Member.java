package spring.project.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Member {
    private Double memberKey;
    private String memberId;
    private String password;
    private String gender;
    private String phoneNumber;
    private String email;
    private String grade;

    public Member(){

    }

    public Member(String memberId, String password, String gender, String phoneNumber, String email){
        this.memberId = memberId;
        this.password = password;
        this.gender= gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Member(Double memberKey, String memberId, String password, String gender, String phoneNumber, String email, String grade){
        this.memberKey= memberKey;
        this.memberId = memberId;
        this.password = password;
        this.gender= gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.grade = grade;
    }

}
