package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    //할인대상 금액 리턴
    int discount(Member member, int price);
}