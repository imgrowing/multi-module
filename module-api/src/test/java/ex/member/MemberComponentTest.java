package ex.member;

import ex.member.domain.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberComponentTest {

    @Autowired
    private MemberComponent memberComponent;

    @Test
    public void save() {
        Member member = new Member("gildong", "gildong@gmail.com");
        Long id = memberComponent.signup(member);
        assertThat(id, is(1L));
    }
}