package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // 스프링 컨테이너. 여기서부터 다 시작된다.
        // AppConfig 에 있는 설정 정보를 객체 생성해서 @Bean() 어노테이션 이 붙은 메서드를 생성한 객체를 가지고 관리한다..
        // key 는 메서드 이름, value 는 클래스로 해서 스프링 컨테이너에 등록됨

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService =  applicationContext.getBean("memberService", MemberService.class);
        // 빈에 등록된 메서드 이름으로 name 이 결정되어있다.

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("findMember = " + findMember);
        System.out.println("member = " + member);
    }
}
