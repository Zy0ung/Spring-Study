package gdsc.hello.gdscTest.dto;

import gdsc.hello.gdscTest.domain.Sport;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateReserveDto {

    private String title;
    private String explanation;

    private Integer recruitmentNum;
    private Sport sport;

    private LocalDateTime startT;
    private LocalDateTime endT;

}