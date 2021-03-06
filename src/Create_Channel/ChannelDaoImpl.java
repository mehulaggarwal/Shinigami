package Create_Channel;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("channelDao")
public class ChannelDaoImpl implements ChannelDao{

	@Autowired
    SessionFactory sessionFactory;
	private boolean add;
	
	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(Channel Channel1) {
		 
		getSession().save(Channel1);
	}

	@Override
	public void update(Channel Channel1) {
		getSession().update(Channel1);
		
	}

	@Override
	public void delete(String channel_name) {
		getSession().delete(channel_name);
		
	}

	@Override
	public Channel edit(String channel_name) {
		return find(channel_name);
	}

	@Override
	public Channel find(String channel_name) {
		return getSession().get(Channel.class,channel_name);
	}

	@Override
	public List<Channel> getAll() {
		return getSession().createCriteria(Channel.class).list();
	}

	@Override
	public List<Channel> getChannelNames(int user_id) {
		Query query=getSession().getNamedQuery("ChannelNames");
		query.setInteger(0,user_id);
		List<Channel> channels=(List<Channel>)query.list();
		return channels;
	}

}
