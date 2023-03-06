package study.paging;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import study.paging.entity.Member;
import study.paging.entity.MemberInfo;
import study.paging.entity.Reserve;

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

            MemberInfo memberInfo = new MemberInfo("서울");
            MemberInfo memberInfo1 = new MemberInfo("경기");
            MemberInfo memberInfo2 = new MemberInfo("천안");

            em.persist(memberInfo);
            em.persist(memberInfo1);
            em.persist(memberInfo2);

            Member member = Member.addMember("찬우","qwer","1234",memberInfo);
            Member member1 = Member.addMember("훈일","asdf","1234",memberInfo1);
            Member member2 = Member.addMember("성호","zxcv","1234",memberInfo2);

            em.persist(member);
            em.persist(member1);
            em.persist(member2);

            Reserve reserve1 = Reserve.createReserve(member, "A", "helloA");
            Reserve reserve2 = Reserve.createReserve(member, "B", "helloB");
            Reserve reserve3 = Reserve.createReserve(member, "C", "helloC");
            Reserve reserve4 = Reserve.createReserve(member, "D", "helloD");
            Reserve reserve5 = Reserve.createReserve(member1, "E", "helloE");
            Reserve reserve6 = Reserve.createReserve(member2, "F", "helloF");

            em.persist(reserve1);
            em.persist(reserve2);
            em.persist(reserve3);
            em.persist(reserve4);
            em.persist(reserve5);
            em.persist(reserve6);

            em.flush();

            em.clear();


        }


    }
}