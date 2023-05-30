package hello11.core;

import hello11.core.member.Grade;
import hello11.core.member.Member;
import hello11.core.member.MemberService;
import hello11.core.member.MemberServiceImpl;
import hello11.core.order.Order;
import hello11.core.order.OrderService;
import hello11.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member memberA = new Member(memberId, "memberA", Grade.Vip);

        memberService.joinMember(memberA);
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());

    }
}
