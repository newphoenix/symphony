package ba.sec.app.secApp.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ba.sec.secApp.model.Person;

@RestController
@RequestMapping("person")
public class PersonRestController {
	
	@PostMapping(value="/save",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> saveUser(@RequestBody @Valid Person person, Errors errors) {
		
		 Result result = new Result();
		 result.setPerson(person);

	        if (errors.hasErrors()) {	        	
	        	List<String>messages = errors.getAllErrors().stream()
	    				               .map(x -> x.getDefaultMessage())
	    				               .collect(Collectors.toList());
	    			
	    		   result.setMessages(messages);		
	    		   result.setMsg("error");        	   

	              return ResponseEntity.badRequest().body(result);	        	
	        }

        System.out.println("-- "+person);
        
        result.setMsg("success");
        
        
        return ResponseEntity.ok(result);
	}

}
