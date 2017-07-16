package ba.sec.app.utils;

import java.util.stream.Collectors;

import org.springframework.validation.Errors;

import ba.sec.app.constants.Constants;
import ba.sec.app.dto.ErrorMsg;

public class ValidationMessageUtils {
	
	public static ErrorMsg buildMessage(Errors errors){
		
		ErrorMsg result = new ErrorMsg();
		
	   result.setResult(errors.getAllErrors()
          		 .stream().map(x -> x.getDefaultMessage()+Constants.BREAK_LINE)
                      .collect(Collectors.toList()));
          
          result.setMsg(Constants.NOK_);          
          
          return result;		
	}

}
