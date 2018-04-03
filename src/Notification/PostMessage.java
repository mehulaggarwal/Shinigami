package Notification;

import login_and_register.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import deletemessages.*;
@Entity
@NamedNativeQuery(name="getMessages",query="select * from post_message where notification_id IN  (select notification_id from post_message left join delete_messages using(Notification_id) where delete_messages.notification_id is NULL order by notification_id desc) and channel_id=?",resultClass=PostMessage.class)
@Table(name = "Post_Message")
public class PostMessage {
	
	@Column(length=20000)
	private String message;

    @Id @GeneratedValue
	private int Notification_id;
	
	private int channel_id;
	
	
	private String channel_name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getChannel_name() {
		return channel_name;
	}

	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getNotification_id() {
		return Notification_id;
	}

	public void setNotification_id(int notification_id) {
		Notification_id = notification_id;
	}

	public int getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(int channel_id) {
		this.channel_id = channel_id;
	}


}
