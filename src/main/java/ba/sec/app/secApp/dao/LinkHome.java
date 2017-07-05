package ba.sec.app.secApp.dao;
// Generated Jul 5, 2017 1:57:06 PM by Hibernate Tools 4.3.1.Final

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import ba.sec.app.secApp.modelx.Link;

/**
 * Home object for domain model class Link.
 * @see ba.sec.app.modelx2.Link
 * @author Hibernate Tools
 */
@Repository
public class LinkHome {

	private static final Log log = LogFactory.getLog(LinkHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Link transientInstance) {
		log.debug("persisting Link instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Link persistentInstance) {
		log.debug("removing Link instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Link merge(Link detachedInstance) {
		log.debug("merging Link instance");
		try {
			Link result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Link findById(Integer id) {
		log.debug("getting Link instance with id: " + id);
		try {
			Link instance = entityManager.find(Link.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Link> getAll(Integer userId) {		
		     List<Link> result = null;
			try {
				result =  (List<Link>) entityManager.createNativeQuery("SELECT link,tag FROM LINK WHERE user_id = :id")
			              .setParameter("id", userId).getResultList();
				
		} catch (Exception re) {		
			log.error("getAll failed", re);	
		}
		
			return result;
		}
	
	@SuppressWarnings("unchecked")
	public List<String> getSuggestions(String link) {

		List<String> result = null;
		try {
			result = (List<String>) entityManager.createNativeQuery("SELECT tag from link where link= :link group by tag order by count(id) desc")
					.setParameter("link", link).getResultList();

		} catch (Exception re) {
			log.error("getAll failed", re);
		}

		return result;

	}
	
}
