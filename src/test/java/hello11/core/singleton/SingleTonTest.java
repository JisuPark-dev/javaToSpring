package hello11.core.singleton;

import hello11.core.AppConfig;
import hello11.core.member.MemberService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class SingleTonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        //1. 조회: 호출 할 때마다 객체를 생성하는지
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        Assertions.assertThat(memberService1).isNotEqualTo(memberService2);

    }
    public static void main(String[] args){
        SingletonService singletonService = SingletonService.getInstance();
        singletonService.logic();
    }

    @Test
    @DisplayName("싱글톤 테스트")
    void singletonTest() {
        //given
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();
        //when

        //then
        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("spring container 싱글톤 테스트")
    void springContainerSingletonTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //1. 조회: 호출 할 때마다 객체를 생성하는지
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
