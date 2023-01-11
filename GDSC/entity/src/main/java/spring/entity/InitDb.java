package spring.entity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component  // 스프링빈 등록
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct  //bean이 여러 번 초기화되는 걸 방지할 수 있다.
    public void init() {
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor // 생성자 주입
    static class InitService {

        private final EntityManager em;


        public void dbInit1() {

            Member member = new Member();
            member.setId(1L);
            member.setAge(30);
            member.setUsername("김찬우");

            Member member1 = new Member();
            member1.setId(2L);
            member1.setAge(20);
            member1.setUsername("이훈일");

            em.persist(member);
            em.persist(member1);

            em.flush();

            em.clear();


        }


    }
}