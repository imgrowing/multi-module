package ex.member;

import ex.db1.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    private MemberComponent memberComponent;

    @GetMapping("/member")
    public Member get(@RequestParam(name = "name") String name) {

        Member newMember = new Member(name, name + "@gmail.com");
        Long newId = memberComponent.signup(newMember);
        return memberComponent.getById(newId);
    }
}
