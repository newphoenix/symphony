package ba.sec.app.secApp.dao;
// Generated Jul 3, 2017 10:18:42 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import ba.sec.app.secApp.modelx.Authority;
import ba.sec.app.secApp.modelx.AuthorityId;

/**
 * Home object for domain model class Authority.
 * @see ba.sec.app.secApp.modelx.Authority
 * @author Hibernate Tools
 */
@Repository
public class AuthorityHome {

	private static final Log log = LogFactory.getLog(AuthorityHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Authority transientInstance) {
		log.debug("persisting Authority instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Authority persistentInstance) {
		log.debug("removing Authority instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Authority merge(Authority detachedInstance) {
		log.debug("merging Authority instance");
		try {
			Authority result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Authority findById(AuthorityId id) {
		log.debug("getting Authority instance with id: " + id);
		try {
			Authority instance = entityManager.find(Authority.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
