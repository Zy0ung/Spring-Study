package gdsc.hello.gdscTest.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Reserve {

    @Id @GeneratedValue
    @Column(name = "reserve_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Sport sport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime startT;
    private LocalDateTime endT;

    private String title;
    private String explanation;
    private Integer recruitmentNum;


    //연관관계 메서드//  member가 생성될 때  Member 클래스 안에있는 reserveList에 memeber를 추가하기 위한 메서드
    public void addMember(Member member){
        this.member=member;
        member.getReserveList().add(this);
    }


    //==생성 메서드==//
    public static Reserve createReserve(Member member,String title, String explanation,
                                        Integer recruitmentNum, Sport sport, LocalDateTime startT, LocalDateTime endT){
        Reserve reserve = new Reserve();
        reserve.addMember(member);
        reserve.setTitle(title);
        reserve.setExplanation(explanation);
        reserve.setRecruitmentNum(recruitmentNum);
        reserve.setSport(sport);
        reserve.setStartT(startT);
        reserve.setEndT(endT);
        return reserve;
    }

}