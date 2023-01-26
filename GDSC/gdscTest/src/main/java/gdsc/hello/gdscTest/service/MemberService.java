package gdsc.hello.gdscTest.service;

import gdsc.hello.gdscTest.domain.Member;
import gdsc.hello.gdscTest.domain.Reserve;
import gdsc.hello.gdscTest.dto.AddMemberDto;
import gdsc.hello.gdscTest.repository.MemberRepository;

import gdsc.hello.gdscTest.repository.ReserveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    private final ReserveRepository reserveRepository;


    // 멤버 생성
    @Transactional
    public Long createMember(AddMemberDto addMemberDto){
        Member member = Member.addMember(addMemberDto.getUsername(),
                addMemberDto.getLoginId(),
                addMemberDto.getPassword()
        );
        memberRepository.save(member);
        return member.getId();
    }


    // 리스트 조회
    @Transactional
    public List<Reserve> getMyList(Long memberId){
        return reserveRepository.createdByMe(memberId);
    }


    //삭제
    @Transactional
    public void deleteMember(Long memberId){
        Member findMember = memberRepository.findOne(memberId);
        memberRepository.delete(findMember);
    }

}