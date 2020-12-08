package ex.member;

import ex.member.domain.Member;
import ex.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberComponent {

    private final MemberService memberService;

    public Long signup(Member member) {
        return memberService.signup(member);
    }
}
