package hello11.core.Order;

import hello11.core.AppConfig;
import hello11.core.discount.DiscountPolicy;
import hello11.core.discount.FixDiscountPolicy;
import hello11.core.member.*;
import hello11.core.order.Order;
import hello11.core.order.OrderService;
import hello11.core.order.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OrderTest {

    MemberService memberService;
    OrderService orderService;
    DiscountPolicy discountPolicy = new FixDiscountPolicy();

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
    void discountTest() {
        //given
        Member member = new Member(1L, "jisu", Grade.Vip);
        memberService.joinMember(member);
        Order order = orderService.createOrder(1L, "item1", 10000);

        //when
        int discountedPrice = discountPolicy.discount(member, 10000);

        //then
        assertEquals(order.getDiscountPrice(),1000);
        assertEquals(order.calculatePrice(),9000);
    }

}
