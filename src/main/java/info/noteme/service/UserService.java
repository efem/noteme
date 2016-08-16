package info.noteme.service;

import java.util.List;

import info.noteme.domain.User;

public interface UserService {

	User getUserByUsername(String username);
	
	List<User> findAll();
	
	User save(User user);
	
	User updateLoginDate(User user);

}
