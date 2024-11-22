package termproject.heroticketing.member.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String memberId;
    private String password;
    private MemberRole role;

    public Member() {
    }

    @Builder
    public Member(String memberId, String password, String role) {
        this.memberId = memberId;
        this.password = password;
        this.role = MemberRole.valueOf(role.toUpperCase());
    }
}
