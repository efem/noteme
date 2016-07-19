package info.noteme.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.PersistenceUnit;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.GenerationType;

@Entity
@Table(name="USERS")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1617955555423512691L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@NotNull
	@Size(min=3, max=16, message="{error.username.size}")
	private String username;
	
	@NotNull
	@Size(min=7, max=25, message="{error.email.size}")
	private String email;
	
	@NotNull
	private String password;
	
	@Transient
	private String passwordVerify;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name="users_roles",
			joinColumns={@JoinColumn(name = "userid")},
			inverseJoinColumns={@JoinColumn(name = "roleid")}
			)
	private List<Role> roles;

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	private boolean isDeleted;
	
	
	public String getPasswordVerify() {
		return passwordVerify;
	}

	public void setPasswordVerify(String passwordVerify) {
		this.passwordVerify = passwordVerify;
	}

	
	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public User() {
		this(null, null, null);
	}
	public User(String username, String email, String password) {
		this(username, email, password, null);
	}
	
	public User(String username, String email, String password, List<Role> roles) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles=roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	

	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
