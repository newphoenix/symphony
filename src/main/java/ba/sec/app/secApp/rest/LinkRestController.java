package ba.sec.app.secApp.rest;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ba.sec.app.constants.Constants;
import ba.sec.app.dto.ErrorMsg;
import ba.sec.app.dto.LinkResult;
import ba.sec.app.dto.TagResult;
import ba.sec.app.secApp.modelx.Link;
import ba.sec.app.secApp.service.ILinkService;
import ba.sec.app.utils.LinkUtils;
import ba.sec.app.utils.ValidationMessageUtils;

@RestController
@RequestMapping("link")
public class LinkRestController {
	
	@Resource(name="linkService")
	ILinkService linkService;

	@PostMapping(value="/save",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> saveUrl(@RequestBody @Valid  Link link, Errors errors,Principal princ) {
		
		System.out.println(link);
		
		 if (errors.hasErrors()) {	    	
		    	ErrorMsg errorMsg = ValidationMessageUtils.buildMessage(errors);
	            return ResponseEntity.ok(errorMsg);
		        }
		
		String url = link.getLink();
		int andNumber = LinkUtils.countChars(url, Constants.AND);
		String param1 = LinkUtils.paramsInUrl(url);
		List<String> paramLst1 = LinkUtils.splitParams(param1);
		
		String url2 = LinkUtils.checkAndChop(url);

		List<String> userLinks = linkService.getUserLinks(url2,princ.getName());
		
		LinkResult result = new LinkResult();
		result.setMsg(Constants.LINK_EXIST);
		
       if(!LinkUtils.checkLinkExist(userLinks,andNumber,paramLst1,url))	{	
    	   result.setMsg(linkService.addLink(link,princ.getName()));            
       }
       
        return ResponseEntity.ok(result);
	}
	
	@GetMapping(value="/getAll",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public LinkResult loadLinks(Principal princ) {

        LinkResult result = linkService.readLinks(princ.getName());
        
        return result;
	}
	
	@GetMapping(value="/getSuggestions",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TagResult getSuggestions(@RequestParam("link")String link) {

		TagResult result = linkService.getSuggestions(link);
        
        return result;
	}
	
	

}
