package gdsc.hello.gdscTest.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;

    private String password;

    private String loginId;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<Reserve> reserveList = new ArrayList<>();


    //==생성 메서드==//
    public static Member addMember(String username,  String loginId, String password){

        Member member = new Member();
        member.setUsername(username);
        member.setLoginId(loginId);
        member.setPassword(password);
        return member;
    }



}