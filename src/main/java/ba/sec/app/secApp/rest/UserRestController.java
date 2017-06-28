package ba.sec.app.secApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ba.sec.secApp.model.User;

@RestController
@RequestMapping("user")
public class UserRestController {
	
	@Value("${message}")
	private String message;
	
	@GetMapping("/25")
	public User getUser(){
		return new User("Alen","Kaku",25);
	}
	
	@GetMapping("/msg")
	public String getMessage(){
		return message;
	}

}
