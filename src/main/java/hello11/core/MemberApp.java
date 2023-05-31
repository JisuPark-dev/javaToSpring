package hello11.core;

import hello11.core.member.Grade;
import hello11.core.member.Member;
import hello11.core.member.MemberService;
import hello11.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member member1 = new Member(1L, "jisu", Grade.Vip);
        Member member2 = new Member(2L, "dasun", Grade.Vip);

        memberService.joinMember(member1);
        memberService.joinMember(member2);

        System.out.println(memberService.findMember(1).getName());
        System.out.println(member1.getName());
    }
}
