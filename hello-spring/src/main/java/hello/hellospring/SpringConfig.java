package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//    //메모리 - return new MemoryMemberRepository();
//    //순수 JDBC - return new JdbcMemberRepository(dataSource);
//    //JDBC Template - return new JdbcTemplateMemberRepository(dataSource);
//    //JPA - return new JpaMemberRepository(em);
//    }
}
