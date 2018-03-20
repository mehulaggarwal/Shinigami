package Notification;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

	

}
