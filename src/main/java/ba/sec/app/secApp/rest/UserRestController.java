package ba.sec.app.secApp.rest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ba.sec.app.secApp.service.IUserService;
import ba.sec.secApp.model.User;

@RestController
@RequestMapping("user")
public class UserRestController {
	
	private static final String OK = "{\"result\":\"ok\"}";
	
	@Resource(name="userService")
	IUserService userService;
	
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
	
	
	@PostMapping(value="/save",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String saveUser(@RequestBody User user) {

        System.out.println("-- "+user);
        
        return OK;
	}
	
	@GetMapping("/getUsers") 
	public List<ba.sec.app.secApp.modelx.User> getUsers(){
		return userService.getAllUsers();
	}

}
