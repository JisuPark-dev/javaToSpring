package hello11.core.discount;

import hello11.core.member.Grade;
import hello11.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.Vip){
            return price*discountPercent/100;
        }
            return 0;
    }
}
