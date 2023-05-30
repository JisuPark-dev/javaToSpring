package hello11.core.discount;

import hello11.core.member.Grade;
import hello11.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int DiscountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.Vip){
            return DiscountFixAmount;
        }
        return 0;
    }
}
