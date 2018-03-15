package Create_Channel;

import login_and_register.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="Create_Channel")
public class Channel {

 	/*@GeneratedValue(generator="newGenerator")
	@GenericGenerator(name="newGenerator",strategy="foreign",parameters={@Parameter(value="user",name="property")})
	private int user_id;*/

	@Id @GeneratedValue
	private int channel_id;

	private String channel_name;
   
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;

	public String getChannel_name() {
		return channel_name;
	}

	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}

	/*public synchronized int getUser_id() {
		return user_id;
	}

	public synchronized void setUser_id(int user_id) {
		this.user_id = user_id;
	}*/

	public synchronized int getChannel_id() {
		return channel_id;
	}

	public synchronized void setChannel_id(int channel_id) {
		this.channel_id = channel_id;
	}

	public synchronized User getUser() {
		return user;
	}

	public synchronized void setUser(User user) {
		this.user = user;
	}

}
