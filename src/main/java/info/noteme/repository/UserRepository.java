package info.noteme.repository;

import java.util.List;

import info.noteme.domain.User;

public interface UserRepository {

	User getUser(User username);
	
	List<User> getAllUsers();
	
	User save(User user);
}
