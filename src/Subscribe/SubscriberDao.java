package Subscribe;

import java.util.List;

public interface SubscriberDao {

	public void create(Subscriber person);
	
	public void update(Subscriber person);
	
	public void delete(Subscriber person);
	
	public List<Subscriber> getSubscribedChannels(int user_id);
}
