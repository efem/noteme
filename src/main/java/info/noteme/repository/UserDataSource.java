package info.noteme.repository;

import java.util.List;

import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.stereotype.Repository;

import info.noteme.domain.User;

@Repository
public class UserDataSource implements UserRepository {
	User user;
	

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User save(User user) {
		//user = new User();
		System.out.println("SAVING USER" + user);
		return user;
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
