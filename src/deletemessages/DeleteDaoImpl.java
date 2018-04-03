package deletemessages;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("deleteDao")
public class DeleteDaoImpl implements DeleteDao{

	@Autowired
    SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(Delete delete) {
		getSession().save(delete);
	}

	@Override
	public void update(Delete delete) {
		getSession().update(delete);
		
	}

	@Override
	public void delete(Delete delete) {
		getSession().delete(delete);
		
	}

}
