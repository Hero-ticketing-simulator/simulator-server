package termproject.heroticketing.member.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import termproject.heroticketing.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    public Optional<Member> findByMemberId(String memberId);
}
