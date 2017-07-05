package ba.sec.app.secApp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String homePage(){
		return "home";
	}
	
	
	@GetMapping("login")
	public String login(){
		return "login";
	}

	@GetMapping("user")
	public String userPage(){
		return "user";
	}	
	
	@GetMapping("register")
	public String register(){
		return "register";
	}
	
	@GetMapping("person")
	public String personPage(){
		return "person";
	}

}
