package ba.sec.app.secApp.service;

import ba.sec.app.secApp.modelx.Link;
import ba.sec.app.secApp.rest.LinkResult;
import ba.sec.app.secApp.rest.TagResult;

public interface ILinkService {
    public String addLink(Link link,String email);

	public LinkResult readLinks(String name);

	public TagResult getSuggestions(String link);
}
