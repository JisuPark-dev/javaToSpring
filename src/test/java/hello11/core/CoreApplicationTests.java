package hello11.core;

import hello11.core.member.Grade;
import hello11.core.member.Member;
import hello11.core.member.MemberService;
import hello11.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest

class CoreApplicationTests {
	MemberService memberService = new MemberServiceImpl();

	@Test
	void sameTest() {
		//given
		Member member3 = new Member(3L, "jiho", Grade.Basic);
		//when
		memberService.joinMember(member3);
		//then
		Member findMember = memberService.findMember(3);
		assertEquals(member3,findMember);
	}

}
