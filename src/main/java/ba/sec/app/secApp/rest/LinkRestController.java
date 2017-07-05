package ba.sec.app.secApp.rest;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ba.sec.app.secApp.modelx.Link;
import ba.sec.app.secApp.service.ILinkService;

@RestController
@RequestMapping("link")
public class LinkRestController {
	
	@Resource(name="linkService")
	ILinkService linkService;

	@PostMapping(value="/save",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String saveUser(@RequestBody Link link,Principal princ) {

        System.out.println("-- "+link);
        System.out.println("-- "+princ.getName());
        String result = linkService.addLink(link,princ.getName());
        
        return result;
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
