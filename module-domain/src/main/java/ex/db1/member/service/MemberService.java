package ex.db1.member.service;

import ex.db1.member.domain.Member;
import ex.db1.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long signup(Member member) {
        return memberRepository.save(member).getId();
    }

    public Member getById(Long id) {
        return memberRepository.findOne(id);
    }
}
