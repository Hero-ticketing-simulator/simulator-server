package termproject.heroticketing.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import termproject.heroticketing.member.domain.Member;
import termproject.heroticketing.member.dto.SignUpForm;
import termproject.heroticketing.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    public void signUp(SignUpForm form) {
        Member member = Member.builder()
                .name(form.getUsername())
                .password(form.getPassword())
                .role(form.getRole())
                .build();
        memberRepository.save(member);
    }
}
