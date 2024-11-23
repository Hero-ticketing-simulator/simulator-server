package termproject.heroticketing.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import termproject.heroticketing.member.dto.SignUpForm;
import termproject.heroticketing.member.service.MemberService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/add")
    public String signUpForm() {
        return "signUp-form";
    }

    @PostMapping("/add")
    public String signUp(@ModelAttribute SignUpForm form) {
        memberService.signUp(form);
        return "redirect:/";
    }
}
