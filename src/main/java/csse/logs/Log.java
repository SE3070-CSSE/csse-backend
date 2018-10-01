package csse.logs;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="logs")
public class Log {
	
	@Id
	private String _id;
	
	@NotNull
	private Date LoggedDate;
	
	@DBRef
	private Message message;

	@JsonCreator
	public Log( @JsonProperty("loggedDate") Date loggedDate,
			@JsonProperty("message") Message message) {		
		LoggedDate = loggedDate;
		this.message = message;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Date getLoggedDate() {
		return LoggedDate;
	}

	public void setLoggedDate(Date loggedDate) {
		LoggedDate = loggedDate;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Log [_id=" + _id + ", LoggedDate=" + LoggedDate + ", message=" + message + "]";
	}
	
	
}
