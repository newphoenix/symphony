package ba.sec.app.secApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ba.sec.app.secApp.dao.UserHome;
import ba.sec.app.secApp.modelx.User;

@Service("userService")
@Transactional
public class UserService implements IUserService {
	
	@Autowired
	UserHome userDao;

	@Override
	@Transactional(readOnly = true)
	public List<User> getAllUsers() {		
		return userDao.getAllUsers();
	}

}
