package termproject.heroticketing.member.controller;

import static termproject.heroticketing.constant.SessionConst.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import termproject.heroticketing.constant.SessionConst;
import termproject.heroticketing.member.domain.Member;
import termproject.heroticketing.member.dto.LoginForm;
import termproject.heroticketing.member.service.LoginService;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "index";
        }
        return "main";
    }

    @GetMapping("/login")
    public String loginFrom() {
        return "index";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginForm form, HttpServletRequest request) {
        Member loginMember = loginService.login(form.getLoginId(), form.getPassword());
        if (loginMember == null) {
            return "index";
        }

        // 로그인 성공 동작
        HttpSession session = request.getSession();
        session.setAttribute(LOGIN_MEMBER.getMessage(), loginMember);
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
