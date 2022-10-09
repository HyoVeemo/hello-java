package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        // 1. 조회 및 호출할 때 마다 객체 생성
        MemberService memberService1  = appConfig.memberService();
        MemberService memberService2  = appConfig.memberService();

        // 2. 참조값이 다른 것 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }


    @Test
    @DisplayName("singleton 패턴 적용한 객체 사용")
    void singletonServiceTest(){
        SingletonService s1 = SingletonService.getInstance();
        SingletonService s2 = SingletonService.getInstance();


        // 2. 참조값이 다른 것 확인
        System.out.println("SingletonService1 = " + s1);
        System.out.println("SingletonService2 = " + s2);

        Assertions.assertThat(s1).isSameAs(s2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        ApplicationContext appConfig = new AnnotationConfigApplicationContext(AppConfig.class);
        // 1. 조회 및 호출
        MemberService memberService1  = appConfig.getBean("memberService", MemberService.class);
        MemberService memberService2  = appConfig.getBean("memberService", MemberService.class);

        // 2. 참조값이 다른 것 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }

}
