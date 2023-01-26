package gdsc.hello.gdscTest.controller;

import gdsc.hello.gdscTest.dto.AllMatchDto;
import gdsc.hello.gdscTest.dto.CreateReserveDto;
import gdsc.hello.gdscTest.dto.UpdateReserveDto;
import gdsc.hello.gdscTest.domain.Reserve;
import gdsc.hello.gdscTest.response.SuccessResponse;
import gdsc.hello.gdscTest.service.ReserveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reserve")
@RequiredArgsConstructor
public class ReserveController {

    private final ReserveService reserveService;

    //경기 생성하기
    @PostMapping("/create-match/{memberId}")
    public ResponseEntity createMatch(@PathVariable Long memberId,@RequestBody CreateReserveDto createReserveDto){

        Long reserveId = reserveService.createReserve(memberId,createReserveDto);

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,reserveId));
    }

    //모든 매치 보여주기
    @GetMapping("/get/all-match")
    public ResponseEntity getAllMatch(){

        List<Reserve> reserve = reserveService.allMatch();

        List<AllMatchDto> collect = reserve.stream().map(r -> new AllMatchDto(r)).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,collect));

    }

    //경기 업데이트
    @PostMapping("/edit/{reserveId}")
    public ResponseEntity updateReserve(@PathVariable Long reserveId, @RequestBody UpdateReserveDto reserveDto) {

        Long reserve = reserveService.updateReserve(reserveId, reserveDto);

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200, reserve));
    }

    //경기 삭제하기
    @DeleteMapping("/delete/{reserveId}")
    public ResponseEntity deleteReserve(@PathVariable Long reserveId){

        reserveService.deleteReserve(reserveId);

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200, null));
    }
}