package info.noteme.helper;

import java.util.ArrayList;
import java.util.List;

import info.noteme.domain.Role;
import info.noteme.domain.User;
import info.noteme.service.RoleService;

public class UserHelper {	
	public static User setUserRoles(User user, String[] roles, RoleService roleService) {
		List<Role> roleList = new ArrayList<>();

		for (int i = 0; i< roles.length; i++) {
			try {
				roleList.add(roleService.getRoleById(Long.parseLong(roles[i])));
			} catch (NumberFormatException nfe) {
				roleList.add(roleService.getRoleByName(roles[i]));
			}
		}
		user.setRoles(roleList);
		return user;	
	}
}
