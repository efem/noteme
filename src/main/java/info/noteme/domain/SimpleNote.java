package info.noteme.domain;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.stereotype.Component;

import info.noteme.interf.Note;

@Component
public class SimpleNote implements Note {

	private final Long id;
	private final String message;
	private final Date time;
	private Double latitude;
	private Double longitude;

	public SimpleNote() {
		this(null, null);
	}
	public SimpleNote(String message, Date time) {
		this(message, time, null, null);
	}

	public SimpleNote(String message, Date time, Double longitude, Double latitude) {
		this.id = null;
		this.message = message;
		this.time = time;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public Date getTime() {
		return time;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that, new String[] {"id","time"});
	}
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, new String[] {"id","time"});
	}
	public void printBody() {

	}

}
