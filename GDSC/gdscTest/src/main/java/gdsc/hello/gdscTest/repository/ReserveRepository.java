package gdsc.hello.gdscTest.repository;

import gdsc.hello.gdscTest.domain.Reserve;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReserveRepository {

    private final EntityManager em;

    //저장
    public void save(Reserve reserve){
        em.persist(reserve);
    }

    //찾기
    public Reserve findOne(Long id){
        return em.find(Reserve.class,id);
    }

    //삭제
    public void delete(Reserve reserve){
        em.remove(reserve);
    }

    //모든 경기 보여주기
    public List<Reserve> findAll(){
        return em.createQuery("select r from Reserve r", Reserve.class)
                .getResultList();
    }

    // 내가 참여한 경기 보여주기
    public List<Reserve> createdByMe(Long memberId){
        return em.createQuery("select r from Reserve r" +
                        " join fetch r.member m where m.id =: memberId", Reserve.class)
                .setParameter("memberId",memberId).getResultList();
    }

}