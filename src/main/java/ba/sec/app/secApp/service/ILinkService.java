package ba.sec.app.secApp.service;

import java.util.List;

import ba.sec.app.dto.LinkResult;
import ba.sec.app.dto.TagResult;
import ba.sec.app.secApp.modelx.Link;

public interface ILinkService {
    public String addLink(Link link,String email);

	public LinkResult readLinks(String name);

	public TagResult getSuggestions(String link);

	public List<String> getUserLinks(String url2, String name);

}
