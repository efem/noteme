package info.noteme.service;

import java.util.List;

import info.noteme.domain.Role;

public interface RoleService {
	List<Role> findAll();
	
	Role getRoleById(Long id);
	
	Role getRoleByName(String roleName);
}
