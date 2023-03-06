package study.auditing;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.auditing.entity.Member;
import study.auditing.entity.Team;
import study.auditing.repository.MemberRepository;
import study.auditing.repository.TeamRepository;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
@Rollback(false)
class JpaBaseEntityTest {

    @Autowired
    EntityManager em;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    TeamRepository teamRepository;
    @Test
    public void jpa를_활용한_Auditing() throws Exception {

        //given
        Member member = new Member("찬우",40);
        memberRepository.save(member);  //@PrePersist

        Thread.sleep(1000);  //업데이트 확인을 위해
        member.setName("훈일");

        em.flush();  //@PreUpdate
        em.clear();

        Member member1 = memberRepository.findById(member.getId()).get();
        System.out.println("member1.getCreatedDate() = " + member1.getCreatedDate());
        System.out.println("member1.getCreatedDate() = " + member1.getUpdatedDate());
    }

    @Test
    public void Data_jpa를_활용한_Auditing() throws Exception {

        //given
        Team team = new Team("뮌헨");
        teamRepository.save(team);  //@PrePersist

        Thread.sleep(1000);  //업데이트 확인을 위해
        team.setName("FC서울");

        em.flush();  //@PreUpdate
        em.clear();

        Team findTeam = teamRepository.findById(team.getId()).get();
        System.out.println("findTeam.getName() = " + findTeam.getCreatedDate());
        System.out.println("findTeam.getLastModifyDate() = " + findTeam.getLastModifyDate());
        System.out.println("findTeam.getCreateBy() = " + findTeam.getCreateBy());
        System.out.println("findTeam.getLastModifiedBy() = " + findTeam.getLastModifiedBy());


    }

}