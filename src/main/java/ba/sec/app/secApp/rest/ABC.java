package ba.sec.app.secApp.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ba.sec.secApp.model.User;

@RestController
@RequestMapping("abc")
public class ABC {
	
	// use httpie to call with
	//echo {"firstName":"ax","lastName":"bx","age":18} | http post localhost:8080/abc/save
	@PostMapping(value="/save",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String saveUser(@RequestBody User user) {

        System.out.println("-- "+user);
        
        return "ok";
	}

}
