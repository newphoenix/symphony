package ba.sec.app.secApp.dao;
// Generated Jul 3, 2017 10:18:42 PM by Hibernate Tools 4.3.1.Final

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import ba.sec.app.constants.Constants;
import ba.sec.app.secApp.modelx.User;

/**
 * Home object for domain model class User.
 * @see ba.sec.app.secApp.modelx.User
 * @author Hibernate Tools
 */
@Repository
public class UserHome {

	private static final Log log = LogFactory.getLog(UserHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(User transientInstance) {
		log.debug("persisting User instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(User persistentInstance) {
		log.debug("removing User instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public User findById(Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = entityManager.find(User.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		
		List<User>  users = null; 
		try {
			users = (List<User>) entityManager.createQuery("SELECT u FROM User u").getResultList();
			
		} catch (RuntimeException re) {
			log.error("error getAllUsers  ",re);
		}
		return users;
	}

	public String checkEmailExists(String email) {
		String result = Constants.NOK;
		try {
			BigInteger r =  (BigInteger) entityManager.createNativeQuery("SELECT EXISTS (SELECT 1 FROM( SELECT email FROM user u) a WHERE a.email = :email)")
		              .setParameter("email", email).getSingleResult();
			result = (r.intValue()==1)? Constants.Email_DOES_EXISTS: Constants.NOK;
	} catch (Exception re) {		
		log.error("checkIfEmailExistsInTwoTables failed", re);	
	}
	
		return result;
	}

	public User findByEmail(String email) {
		User result = null;
		try {
			result =  (User) entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email").setParameter("email", email).getSingleResult();
	
	} catch (Exception re) {		
		log.error("checkIfEmailExistsInTwoTables failed", re);	
	}
		
		return result;
	}
}
