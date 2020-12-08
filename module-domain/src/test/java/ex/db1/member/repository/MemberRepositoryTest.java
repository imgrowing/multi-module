package ex.db1.member.repository;

import ex.db1.member.domain.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void add() {
        Member gildong = new Member("gildong", "gildong@gmail.com");
        Member member = memberRepository.save(gildong);
        Member saved = memberRepository.findOne(member.getId());
        assertThat(saved.getName(), is(gildong.getName()));
    }
}