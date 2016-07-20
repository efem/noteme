package info.noteme.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import info.noteme.domain.Role;
import info.noteme.domain.User;

public class UserDetailsHelper implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8418984073822333940L;
	
	private String username;
	private String password;
	private boolean enabled;
	private boolean nonExpired;
	private boolean nonLocked;
	private boolean credNonExpired;
	
	private List<SimpleGrantedAuthority> auths = new ArrayList<SimpleGrantedAuthority>();
	private SimpleGrantedAuthority sga;

	public UserDetailsHelper(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.enabled = user.isEnabled();
		this.nonExpired = true;
		this.nonLocked = true;
		this.credNonExpired = true;
		
		for (Role r : user.getRoles()) {
			sga = new SimpleGrantedAuthority(r.getRolename());
			auths.add(sga);
		}
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.auths;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.nonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.nonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.credNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

}
