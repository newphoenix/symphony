package ba.sec.app.secApp.rest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ba.sec.app.secApp.service.IUserService;

@RestController
@RequestMapping("user")
public class UserRestController {

	@Resource(name="userService")
	IUserService userService;
	
	@GetMapping("/getUsers") 
	public List<ba.sec.app.secApp.modelx.User> getUsers(){
		return userService.getAllUsers();
	}

}
