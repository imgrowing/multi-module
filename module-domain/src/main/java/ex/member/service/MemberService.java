package ex.member.service;

import ex.member.domain.Member;
import ex.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long signup(Member member) {
        return memberRepository.save(member).getId();
    }
}
