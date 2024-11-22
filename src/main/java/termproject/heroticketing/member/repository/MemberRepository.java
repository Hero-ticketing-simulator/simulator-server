package termproject.heroticketing.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import termproject.heroticketing.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
