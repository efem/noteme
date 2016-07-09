package info.noteme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import info.noteme.dao.UserDao;
import info.noteme.domain.User;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
	
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}


	@Override
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}


	@Override
	public User save(User user) {
		return userDao.save(user);
	}

}
