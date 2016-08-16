package info.noteme.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import info.noteme.dao.UserDao;
import info.noteme.domain.User;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	
	static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
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
		User userToSave = user;
		userToSave.setPassword(passwordEncoder.encode(user.getPassword()));
		userToSave.setRegDate(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
		LOG.info("Saving user with password: " + userToSave.getPassword());
		return userDao.save(userToSave);
	}


	@Override
	public User updateLoginDate(User user) {
		user.setLoginDate(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
		return userDao.save(user);
	}
	
	
	

}
