package hello11.core.member;

public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }



    @Override
    public void joinMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(long MemberId) {
        return memberRepository.findById(MemberId);
    }
}
