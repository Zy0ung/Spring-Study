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

    private LocalDateTime startT;
    private LocalDateTime endT;

    private String title;
    private String explanation;
    private Integer recruitmentNum;


    //==생성 메서드==//
    public static Reserve createReserve(String title, String explanation,
                                        Integer recruitmentNum, Sport sport, LocalDateTime endT, LocalDateTime startT){
        Reserve reserve = new Reserve();
        reserve.setTitle(title);
        reserve.setExplanation(explanation);
        reserve.setRecruitmentNum(recruitmentNum);
        reserve.setSport(sport);
        reserve.setStartT(startT);
        reserve.setEndT(endT);
        return reserve;
    }
}