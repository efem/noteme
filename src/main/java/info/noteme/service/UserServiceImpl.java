package info.noteme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.noteme.dao.UserDao;
import info.noteme.domain.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
	
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}


	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
