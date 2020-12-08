package ex.db1.member.domain;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String nickname;

    public Member() {
    }

    public Member(String name, String email, String nickname) {
        this.name = name;
        this.email = email;
        this.nickname = nickname;
    }

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }

}
