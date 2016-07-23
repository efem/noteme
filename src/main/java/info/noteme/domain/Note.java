package info.noteme.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "NOTE")
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String content;

	@NotNull
	private String trynick;

	@NotNull
	private boolean nickfound;

	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;

	public Note() {
		this(null, null);
	}

	public Note(String content, String tryNick) {
		super();
		this.content = content;
		this.trynick = tryNick;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTrynick() {
		return trynick;
	}

	public void setTrynick(String trynick) {
		this.trynick = trynick;
	}

	public boolean isNickfound() {
		return nickfound;
	}

	public void setNickfound(boolean nickfound) {
		this.nickfound = nickfound;
	}

	@Override
	public String toString() {
		return "Note [content=" + content + ", tryNick=" + trynick + "]";
	}

}
