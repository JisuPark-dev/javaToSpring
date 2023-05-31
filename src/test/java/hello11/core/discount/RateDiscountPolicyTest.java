package hello11.core.discount;

import hello11.core.AppConfig;
import hello11.core.member.Grade;
import hello11.core.member.Member;
import hello11.core.member.MemberService;
import hello11.core.member.MemberServiceImpl;
import hello11.core.order.Order;
import hello11.core.order.OrderService;
import hello11.core.order.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RateDiscountPolicyTest {

    DiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();
    MemberService memberService;
    OrderService orderService;

    AppConfig appConfig = new AppConfig();

    @BeforeEach
//    public void beforeEach() {
//        AppConfig appConfig = new AppConfig();
//        memberService = appConfig.memberService();
//        orderService = appConfig.orderService();
//    }
    public void beforeEach() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        memberService = applicationContext.getBean("memberService", MemberService.class);
        orderService = applicationContext.getBean("orderService", OrderService.class);
    }

    @Test
    @DisplayName("VIP고객에게는 10%할인이 적용되어야 한다.")
    void discountTest(){
        //given
        Member member = new Member(1L, "jisu", Grade.Vip);
        memberService.joinMember(member);
        Order order = orderService.createOrder(1L, "item1", 10000);

        //when
        int discount = rateDiscountPolicy.discount(member, 20000);

        //then
        assertEquals(discount, 2000);
    }


}