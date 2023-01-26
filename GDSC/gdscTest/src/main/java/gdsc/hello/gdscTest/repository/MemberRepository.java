package gdsc.hello.gdscTest.repository;

import gdsc.hello.gdscTest.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){
        return em.find(Member.class,id);
    }

    //회원 삭제
    public void delete(Member member){
        em.remove(member);
    }



}