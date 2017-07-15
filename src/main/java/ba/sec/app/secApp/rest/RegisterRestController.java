package ba.sec.app.secApp.rest;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ba.sec.app.secApp.modelx.User;
import ba.sec.app.secApp.service.IUserService;

@RestController
@RequestMapping("register")
public class RegisterRestController{
	
	@Resource(name="userService")
	IUserService userService;

	@PostMapping(value="/save",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String saveUser(@RequestBody User user) {
        
        String result = userService.register(user);        
        return result;
	}

}