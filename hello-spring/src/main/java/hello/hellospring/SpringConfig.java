package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private final EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
    //메모리 - return new MemoryMemberRepository();
    //순수 JDBC - return new JdbcMemberRepository(dataSource);
    //JDBC Template - return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
