package Notification;
import Create_Channel.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Notification")
public class Notification {
  
	private String message;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="channel_id")
	private Channel channel;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	
}
