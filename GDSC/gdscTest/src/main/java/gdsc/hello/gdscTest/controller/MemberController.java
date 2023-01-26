package gdsc.hello.gdscTest.controller;

import gdsc.hello.gdscTest.domain.Reserve;
import gdsc.hello.gdscTest.dto.AddMemberDto;
import gdsc.hello.gdscTest.dto.MyListDto;
import gdsc.hello.gdscTest.response.SuccessResponse;
import gdsc.hello.gdscTest.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;


    //회원 가입
    @PostMapping("/creation")
    public ResponseEntity createMember(@RequestBody AddMemberDto addMemberDto){
        memberService.createMember(addMemberDto);

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,null));
    }

    //내가 생성한 예약 보여주기
    @GetMapping("/get/me/{memberId}")
    public ResponseEntity getMyList(@PathVariable Long memberId){

        List<Reserve> reserve = memberService.getMyList(memberId);

        List<MyListDto> collect = reserve.stream().map(r -> new MyListDto(r)).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,collect));

    }

    //회원 탈퇴
    @DeleteMapping("/delete/{memberId}")
    public ResponseEntity deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,null));
    }



}