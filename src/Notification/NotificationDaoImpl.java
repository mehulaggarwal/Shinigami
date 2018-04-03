package Notification;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Subscribe.MsgNotifiId;

@Repository("notificationDao")
public class NotificationDaoImpl implements NotificationDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(PostMessage notifi) {
		 getSession().save(notifi);
	}

	@Override
	public void update(PostMessage notifi) {
		getSession().update(notifi);
		
	}

	@Override
	public void delete(String message) {
		getSession().delete(message);
		
	}

	@Override
	public List<PostMessage> getMessages(int channel_id) {
		Query query=getSession().getNamedQuery("getMessages");
		query.setInteger(0, channel_id);
		List<PostMessage> messages=(List<PostMessage>)query.list();
		return messages;
	}

	

}
