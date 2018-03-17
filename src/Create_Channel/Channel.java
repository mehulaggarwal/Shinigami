package Create_Channel;

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


@Entity
@NamedNativeQuery(name="ChannelNames",query="Select * from Create_Channel where user_id=?",resultClass=Channel.class)
@Table(name="Create_Channel")
public class Channel {


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
