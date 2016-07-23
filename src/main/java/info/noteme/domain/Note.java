package info.noteme.domain;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="NOTE")
public class Note {
	
	private long id;
	private String content;
	private String tryNick;
	
	
	public Note() {
		this(null, null);
	}
	
	public Note(String content, String tryNick) {
		super();
		this.content = content;
		this.tryNick = tryNick;
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
	public String getTryNick() {
		return tryNick;
	}
	public void setTryNick(String tryNick) {
		this.tryNick = tryNick;
	}

	@Override
	public String toString() {
		return "Note [content=" + content + ", tryNick=" + tryNick + "]";
	}
	
	

}
