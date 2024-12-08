package termproject.heroticketing.performance.controller;

import static termproject.heroticketing.constant.SessionConst.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import termproject.heroticketing.member.domain.Member;
import termproject.heroticketing.performance.service.PerformanceService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/performances")
public class MypageController {

	@GetMapping("/mypage")
	public String myPage(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		Member loginMember = (Member) session.getAttribute(LOGIN_MEMBER.getMessage());
		if (loginMember != null) {
			model.addAttribute("loginMember", loginMember); // 로그인한 멤버를 모델에 추가
		}
		return "mypage";
	}
}
