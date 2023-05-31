package hello11.core;

import hello11.core.discount.DiscountPolicy;
import hello11.core.discount.FixDiscountPolicy;
import hello11.core.discount.RateDiscountPolicy;
import hello11.core.member.MemberService;
import hello11.core.member.MemberServiceImpl;
import hello11.core.member.MemoryMemberRepository;
import hello11.core.order.OrderService;
import hello11.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
