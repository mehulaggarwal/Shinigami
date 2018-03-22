package Subscribe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("subscriberService")
@Transactional(rollbackFor=Exception.class)
public class SubscriberServiceImpl implements SubscriberService{

	@Autowired
	SubscriberDao subscriberDao;

	@Override
	public void create(Subscriber person) {
		subscriberDao.create(person);
	}

	@Override
	public void update(Subscriber person) {
		subscriberDao.update(person);
		
	}

	@Override
	public void delete(Subscriber person) {
		subscriberDao.delete(person);		
	}

	@Override
	public List<Subscriber> getSubscribedChannels(int user_id) {
		return subscriberDao.getSubscribedChannels(user_id);
	}
}
