package termproject.heroticketing.member.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private MemberRole role;

    public Member() {
    }

    @Builder
    public Member(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = MemberRole.valueOf(role.toUpperCase());
    }
}
