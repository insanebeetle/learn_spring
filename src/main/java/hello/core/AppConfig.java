package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//앱 컨피그에서 OCP랑 DIP를 지켜줄수 있음
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return  new MemberServiceImpl(memberRepository());
        //현재 c a m으로 리팩토링 되어잇음 아래 메소드로 대신 넣어주기
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
// OrderService의 경우도 앱컨피그에서
// new MemoryMemberRepository(), new FixDiscountPolicy());가 전부 넘어가기 때문에
// OrderServie의 DPI가 지켜주게됨

    @Bean
    public static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
//MemberServiceImpl코드를 보면 MemoryMemberRepository가 존재하지않음(의존히지않음)
//대신 앱컨피그에서 MemberServiceImpl을 생성할때 생성자를 통해 MemoryMemberRepository를 넣어줄수 있음

    @Bean
    public DiscountPolicy discountPolicy(){
        return  new RateDiscountPolicy();
    }
}
