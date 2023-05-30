package hello11.core.Order;

import hello11.core.discount.DiscountPolicy;
import hello11.core.discount.FixDiscountPolicy;
import hello11.core.member.*;
import hello11.core.order.Order;
import hello11.core.order.OrderService;
import hello11.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OrderTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    DiscountPolicy discountPolicy = new FixDiscountPolicy();
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
