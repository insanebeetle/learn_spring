package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {


    @Test
    @DisplayName("스프링 없는 di 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        //1. 조회 : 호출할때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
        //2. 조회 : 호출할때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();
        //참조 값이 다른것 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
        //위 코드에서 메모리 할당이 총 4번 발생한다
        //싱글톤 패턴 - 객체생성의 new 를 외부에서 사용하기 못하게 막음

    }

    @Test
    @DisplayName("싱글톤 적용된 객체 사용")
    void singletonService() {
        SingletonService singletonService1 = SingletonService.getInsetance();
        SingletonService singletonService2 = SingletonService.getInsetance();
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);
        Assertions.assertThat(singletonService1).isSameAs(singletonService2);

        //same == 참조값(주소) 확인
        //equal == 실제 값 확인

    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //ApplicationContext 자체가 스프링 컨테이너임 appconfig를 wrapping하는 이미지로 싱글톤 구현
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
        //위 코드에서 메모리 할당이 총 4번 발생한다
        //싱글톤 패턴 - 객체생성의 new 를 외부에서 사용하기 못하게 막음

    }
}
