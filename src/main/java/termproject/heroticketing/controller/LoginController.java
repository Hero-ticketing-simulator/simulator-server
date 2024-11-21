package termproject.heroticketing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@PostMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/hello");
		return modelAndView;
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello"; // hello.html을 반환
	}
}
