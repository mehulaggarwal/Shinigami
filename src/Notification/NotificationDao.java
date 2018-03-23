package Notification;

import java.util.List;

public interface NotificationDao {

	public void create(PostMessage notifi);

	public void update(PostMessage notifi);

	public void delete(String message);
	
	public List<String> getMessages(int channel_id);

}
