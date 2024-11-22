package termproject.heroticketing.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import termproject.heroticketing.member.domain.Member;
import termproject.heroticketing.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;
    public Member login(String loginId, String password) {
        return memberRepository.findByMemberId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}
