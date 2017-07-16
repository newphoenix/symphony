package ba.sec.app.secApp.rest;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ba.sec.app.dto.ErrorMsg;
import ba.sec.app.dto.RegisterResult;
import ba.sec.app.secApp.modelx.User;
import ba.sec.app.secApp.service.IUserService;
import ba.sec.app.utils.ValidationMessageUtils;

@RestController
@RequestMapping("register")
public class RegisterRestController{
	
	@Resource(name="userService")
	IUserService userService;

	@PostMapping(value="/save",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> saveUser(@RequestBody @Valid User user, Errors errors) {
		RegisterResult result = new RegisterResult();
		
	    if (errors.hasErrors()) {	    	
	    	ErrorMsg errorMsg = ValidationMessageUtils.buildMessage(errors);
            return ResponseEntity.ok(errorMsg);
	        }
        
        String register = userService.register(user); 
        
        result.setMsg(register);        
        return ResponseEntity.ok(result);
	}

}