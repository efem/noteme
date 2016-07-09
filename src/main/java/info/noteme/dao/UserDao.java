package info.noteme.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import info.noteme.domain.User;

@Component
public interface UserDao extends JpaRepository<User, Long>{
	User getUserByUsername(String username);
	
	User saveAndFlush(User user);
}
