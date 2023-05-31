package hello11.core;

import hello11.core.discount.FixDiscountPolicy;
import hello11.core.discount.RateDiscountPolicy;
import hello11.core.member.MemberService;
import hello11.core.member.MemberServiceImpl;
import hello11.core.member.MemoryMemberRepository;
import hello11.core.order.OrderService;
import hello11.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
