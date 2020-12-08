package ex.member;

import ex.db1.member.domain.Member;
import ex.db1.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberComponent {

    private final MemberService memberService;

    public Long signup(Member member) {
        return memberService.signup(member);
    }

    public Member getById(Long id) {
        return memberService.getById(id);
    }
}
