package ba.sec.app.secApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ba.sec.app.constants.Constants;
import ba.sec.app.dto.LinkResult;
import ba.sec.app.dto.TagResult;
import ba.sec.app.secApp.dao.LinkHome;
import ba.sec.app.secApp.dao.UserHome;
import ba.sec.app.secApp.modelx.Link;
import ba.sec.app.secApp.modelx.User;

@Service("linkService")
@Transactional
public class LinkService implements ILinkService {

	@Autowired
	UserHome userDao;

	@Autowired
	LinkHome linkDao;

	@Override
	public String addLink(Link link, String email) {

		String result = Constants.NOK;

		try {

			User user = userDao.findByEmail(email);

			if (user == null) {
				return result;
			}

			link.setUser(user);
			user.getLinks().add(link);

			linkDao.persist(link);
			userDao.merge(link.getUser());

			result = Constants.OK;

		} catch (Exception ex) {
			// Show add logging
			System.out.println();
		}

		return result;
	}

	@Override
	public LinkResult readLinks(String email) {
		LinkResult result = new LinkResult();
		result.setMsg(Constants.NOK_);

		try {

			User user = userDao.findByEmail(email);

			if (user == null) {
				return result;
			}

			// This returns multilevel object
			// Set<Link> links = user.getLinks();

			List<Link> links = linkDao.getAll(user.getId());

			result.setMsg(Constants.OK_);
			result.setLinks(links);

		} catch (Exception ex) {
			// Show add logging
			System.out.println();
		}

		return result;
	}

	@Override
	public TagResult getSuggestions(String link) {
		TagResult result = new TagResult();
		result.setMsg(Constants.NOK_);

		try {

			List<String> tags = linkDao.getSuggestions(link);

			result.setMsg(Constants.OK_);
			result.setTags(tags);

		} catch (Exception ex) {
			// Should add logging
			System.out.println();
		}

		return result;
	}

	@Override
	public List<String> getUserLinks(String url2, String email) {

		User user = userDao.findByEmail(email);

		if (user == null) {
			return null;
		}

		List<String> urls = linkDao.getLinksSimilarToURL2(url2,user.getId());

		
		return urls;
	}

}
