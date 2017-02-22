package info.noteme.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import info.noteme.domain.Role;

@Component
public interface RoleDao extends JpaRepository<Role, Long>{
	List<Role> findAll();
	
	Role findByRolename(String rolename);
}
