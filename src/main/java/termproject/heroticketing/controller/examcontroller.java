package termproject.heroticketing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class examcontroller {

	@RequestMapping("/hello")
	public String hello() {
		return "/hello.html";
	}
}
