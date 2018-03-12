package login_and_register;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
    SessionFactory sessionFactory;
	
	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void create(User User1) {
		getSession().save(User1);	
	}

	@Override
	public void update(User User1) {
		
		getSession().update(User1);
	}

	@Override
	public User edit(String email) {
		
		return find(email);
	}

	@Override
	public void delete(int id) {
		getSession().delete(id);
	}

	@Override
	public User find(String email) {
	  
		return getSession().get(User.class,email);
	}

	@Override
	public List<User> getAll() {
		return getSession().createCriteria(User.class).list();
	}
	@SuppressWarnings("deprecation")
	@Override
	public User get(String email) {
		Query query=getSession().getNamedQuery("UserDetails.byEmail");
		query.setString(0,email);
		List<User> users=(List<User>)query.list();
		User User1=new User();
		for(User user:users)
		{
			User1=user;
		}
		return User1;
	}

}
