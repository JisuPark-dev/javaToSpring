package hello11.core;

import hello11.core.member.Grade;
import hello11.core.member.Member;
import hello11.core.member.MemberService;
import hello11.core.member.MemberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest

class CoreApplicationTests {
	MemberService memberService;

	@BeforeEach
//	public void beforeEach() {
//		AppConfig appConfig = new AppConfig();
//		memberService = appConfig.memberService();
//	}
	public void beforeEach() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		memberService = applicationContext.getBean("memberService", MemberService.class);
	}


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
