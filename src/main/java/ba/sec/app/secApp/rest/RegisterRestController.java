package ba.sec.app.secApp.rest;

import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ba.sec.app.constants.Constants;
import ba.sec.app.dto.RegisterResult;
import ba.sec.app.secApp.modelx.User;
import ba.sec.app.secApp.service.IUserService;

@RestController
@RequestMapping("register")
public class RegisterRestController{
	
	@Resource(name="userService")
	IUserService userService;

	@PostMapping(value="/save",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> saveUser(@RequestBody @Valid User user, Errors errors) {
		RegisterResult result = new RegisterResult();
		
	    if (errors.hasErrors()) {
	    	
	    	
	            result.setResult(errors.getAllErrors()
	            		 .stream().map(x -> x.getDefaultMessage()+"<br>")
	                        .collect(Collectors.toList()));
	            
	            result.setMsg(Constants.NOK_);

	            return ResponseEntity.ok(result);

	        }
        
        String register = userService.register(user); 
        
        result.setMsg(register);        
        return ResponseEntity.ok(result);
	}

}