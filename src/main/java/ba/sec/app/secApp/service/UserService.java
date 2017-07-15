package ba.sec.app.secApp.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ba.sec.app.constants.Constants;
import ba.sec.app.secApp.dao.AuthorityHome;
import ba.sec.app.secApp.dao.UserHome;
import ba.sec.app.secApp.modelx.Authority;
import ba.sec.app.secApp.modelx.AuthorityId;
import ba.sec.app.secApp.modelx.User;

@Service("userService")
@Transactional
public class UserService implements IUserService {
	
	private static final String ROLE_USER = "ROLE_user";
	
	@Autowired
	UserHome userDao;
	
	@Autowired
	AuthorityHome authorityDao;

	@Override
	@Transactional(readOnly = true)
	public List<User> getAllUsers() {		
		return userDao.getAllUsers();
	}

	@Override
	//@Transactional(rollbackFor = Exception.class, readOnly = false, timeout = 30, propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT)
	public String register(User user){
	    
		String result = Constants.NOK_;
		try{
			
			if(Constants.Email_DOES_EXISTS.equals(userDao.checkEmailExists(user.getEmail()))){
				return result;
			}

			user.setPassword(user.getPassword());
			user.setEnabled(true);
			
			AuthorityId authId = new AuthorityId(user.getEmail(), ROLE_USER);			

			Authority auth = new Authority();
			auth.setId(authId);
			auth.setUser(user);		

			Set<Authority> authSet = new HashSet<Authority>();
			authSet.add(auth);

			user.setAuthorities(authSet);
			
			
			userDao.persist(user);
			authorityDao.persist(auth);
			
			result = Constants.OK_;
			
			
		}catch(Exception ex){
			//should have log system
			System.out.println(ex);
		}
		
		return result;
	}

}
