package info.noteme.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import info.noteme.dao.UserDao;
import info.noteme.domain.User;
import info.noteme.service.UserService;
import info.noteme.helper.UserDetailsHelper;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserDao userDao;
	
	
	@Autowired
	UserService userService;
	
	
	static final Logger LOG = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userDao.getUserByUsername(username);
		if (user == null) {
			LOG.info("User not found - ERROR");
			throw new UsernameNotFoundException("No such user: " + username);
		} else if (user.getRoles().isEmpty()) {
			LOG.info("User not found - ERROR");
			throw new UsernameNotFoundException("User " + username + " has no authorities");
		} else {
			LOG.info("User logged - OK");
			userService.updateLoginDate(user);
		}
		
		return new UserDetailsHelper(user);		
	}

}
