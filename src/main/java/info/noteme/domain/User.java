package info.noteme.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.jws.Oneway;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1617955555423512691L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 3, max = 16, message = "{error.username.size}")
	private String username;

	@NotNull
	@Size(min = 7, max = 25, message = "{error.email.size}")
	private String email;

	@NotNull
	private String password;

	@Transient
	private String passwordVerify;

	private LocalDateTime regDate;

	private LocalDateTime loginDate;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = { @JoinColumn(name = "userid") }, inverseJoinColumns = {
			@JoinColumn(name = "roleid") })
	private List<Role> roles;
	
	@OneToMany(mappedBy = "user")
	private List<Note> notes;


	private boolean enabled;

	public List<Role> getRoles() {
		return roles;
	}

	public User() {
		this(null, null, null);
	}

	public User(String username, String email, String password) {
		this(username, email, password, null, true, null);
	}

	public User(String username, String email, String password, List<Role> roles, boolean isenabled, LocalDateTime regDate) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.enabled = true;
		this.regDate = regDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getPasswordVerify() {
		return passwordVerify;
	}

	public void setPasswordVerify(String passwordVerify) {
		this.passwordVerify = passwordVerify;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public LocalDateTime getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(LocalDateTime loginDate) {
		this.loginDate = loginDate;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", password=" + password + "]";
	}

}
