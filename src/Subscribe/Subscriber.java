package Subscribe;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import login_and_register.*;

@Entity
@NamedNativeQuery(name="SubscribedChannels",query="Select * from Subscriber_info where user_id=?",resultClass=Subscriber.class)
@Table(name="Subscriber_info")
public class Subscriber {

	@Id @GeneratedValue
	private int Subcriber_id;
	
	private int channel_id;
	
	private String channel_name;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;

	public int getSubcriber_id() {
		return Subcriber_id;
	}

	public void setSubcriber_id(int subcriber_id) {
		Subcriber_id = subcriber_id;
	}

	public int getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(int channel_id) {
		this.channel_id = channel_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getChannel_name() {
		return channel_name;
	}

	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}
}
