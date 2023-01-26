package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    // 1
    //    private final DataSource dataSource;

    //    @Autowired
    //    public SpringConfig(DataSource dataSource) {
    //        this.dataSource = dataSource;
    //    }

    // 2
    //    private EntityManager em;
    //
    //    @Autowired
    //    public SpringConfig(EntityManager em){
    //        this.em = em;
    //    }

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }


//  이 프로젝트에서는 컴포넌트 스캔을 사용했습니다.
//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }

//    @Bean
//    public MemberRepository memberRepository() {
    //    return new MemoryMemberRepository();
    //    return new JdbcMemberRepository(dataSource);
    //    return new JdbcTemplateMemberRepository(dataSource);
    //    return new JpaMemberRepository(em);
// }
}
