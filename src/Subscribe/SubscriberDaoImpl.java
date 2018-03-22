package Subscribe;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("subscriberDao")
public class SubscriberDaoImpl implements SubscriberDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void create(Subscriber person) {
		getSession().save(person);
	}

	@Override
	public void update(Subscriber person) {
		getSession().update(person);
	}

	@Override
	public void delete(Subscriber person) {
		getSession().delete(person);
	}
	@Override
	public List<Subscriber> getSubscribedChannels(int user_id) {
	  Query query=getSession().getNamedQuery("SubscribedChannels");
	  query.setInteger(0, user_id);
	  List<Subscriber> subscribed=(List<Subscriber>)query.list();
	  return subscribed;
	}

}
