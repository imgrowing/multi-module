package ex.member;

import ex.member.domain.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @GetMapping("/")
    public Member get() {
        return new Member("gildong", "gildong@gmail.com");
    }
}
