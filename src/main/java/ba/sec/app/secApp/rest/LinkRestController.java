package ba.sec.app.secApp.rest;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ba.sec.app.constants.Constants;
import ba.sec.app.dto.LinkResult;
import ba.sec.app.dto.TagResult;
import ba.sec.app.secApp.modelx.Link;
import ba.sec.app.secApp.service.ILinkService;
import ba.sec.app.urlUtils.LinkUtils;

@RestController
@RequestMapping("link")
public class LinkRestController {
	
	@Resource(name="linkService")
	ILinkService linkService;

	@PostMapping(value="/save",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> saveUrl(@RequestBody Link link,Principal princ) {
		
		String url = link.getLink();
		int andNumber = LinkUtils.countChars(url, Constants.AND);
		String param1 = LinkUtils.paramsInUrl(url);
		List<String> paramLst1 = LinkUtils.splitParams(param1);
		
		String url2 = LinkUtils.checkAndChop(url);

		List<String> userLinks = linkService.getUserLinks(url2,princ.getName());
		
		String result = Constants.LINK_EXIST;
		HttpStatus httpStatus = HttpStatus.OK; 
		
       if(!LinkUtils.checkLinkExist(userLinks,andNumber,paramLst1,url))	{	
          result = linkService.addLink(link,princ.getName());         
       }
        
        return ResponseEntity.status(httpStatus).body(result);
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
