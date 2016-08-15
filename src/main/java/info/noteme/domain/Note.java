package info.noteme.domain;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "NOTE")
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String content;
	
	@NotNull
	private String trynick = "";
	
	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime dateadded;
	
	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime datemodified;
	
	@NotNull
	private boolean mailtosend;
	
	@NotNull
	private boolean wasmailsend;

	@NotNull
	private boolean nickfound;

	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;

	public Note() {
		this(null, null);
	}
	
	public Note(String content) {
		this(content,null);
	}

	public Note(String content, String tryNick) {
		this(content, tryNick, null, null, false, false, false);
	}

	
	public Note(String content, String trynick, LocalDateTime dateadded, LocalDateTime datemodified, boolean mailtosend, boolean wasmailsend,
			boolean nickfound) {
		super();
		this.content = content;
		this.dateadded = dateadded;
		this.datemodified = datemodified;
		this.mailtosend = mailtosend;
		this.wasmailsend = wasmailsend;
		this.trynick = trynick;
		this.nickfound = nickfound;
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

	public LocalDateTime getDateadded() {
		return dateadded;
	}

	public void setDateadded(LocalDateTime dateadded) {
		this.dateadded = dateadded;
	}

	public LocalDateTime getDatemodified() {
		return datemodified;
	}

	public void setDatemodified(LocalDateTime datemodified) {
		this.datemodified = datemodified;
	}

	public boolean isMailtosend() {
		return mailtosend;
	}

	public void setMailtosend(boolean mailtosend) {
		this.mailtosend = mailtosend;
	}

	public boolean isWasmailsend() {
		return wasmailsend;
	}

	public void setWasmailsend(boolean wasmailsend) {
		this.wasmailsend = wasmailsend;
	}

	@Override
	public String toString() {
		return "Note [content=" + content + ", trynick=" + trynick + ", dateadded=" + dateadded + ", datemodified="
				+ datemodified + ", mailtosend=" + mailtosend + ", wasmailsend=" + wasmailsend + ", nickfound="
				+ nickfound + ", user=" + user + "]";
	}


}
