package study.paging.dto;

import lombok.Getter;
import lombok.Setter;
import study.paging.entity.Reserve;

@Getter
@Setter
public class ReserveDto {

    private Long reserveId;

    private String title;

    public ReserveDto(Reserve reserve){
        reserveId = reserve.getId();
        title = reserve.getTitle();
    }

}