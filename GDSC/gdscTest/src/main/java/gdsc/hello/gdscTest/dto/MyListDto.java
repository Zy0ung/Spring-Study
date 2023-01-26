package gdsc.hello.gdscTest.dto;

import gdsc.hello.gdscTest.domain.Reserve;
import gdsc.hello.gdscTest.domain.Sport;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MyListDto {

    private Long reserveId;

    private Sport sport;

    private LocalDateTime startT;
    private LocalDateTime endT;

    private String title;
    private String explanation;
    private Integer recruitmentNum;

    public MyListDto(Reserve reserve) {
        reserveId = reserve.getId();
        sport = reserve.getSport();
        startT = reserve.getStartT();
        endT = reserve.getEndT();
        title = reserve.getTitle();
        explanation = reserve.getExplanation();
        recruitmentNum = reserve.getRecruitmentNum();
    }
}