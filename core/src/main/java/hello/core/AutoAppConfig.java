package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core",
        // 예제 유지 위해서 제외시킴
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    // 해당 클래스는 자동 등록이 되어있기 때문에, 주석 처리한 부분처럼 수동 추가하면 중복 등록 에러가 발생한다.
    @Bean(name= "memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
