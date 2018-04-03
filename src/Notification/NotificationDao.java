package Notification;

import java.util.List;

import Subscribe.MsgNotifiId;

public interface NotificationDao {

	public void create(PostMessage notifi);

	public void update(PostMessage notifi);

	public void delete(String message);
	
	public List<PostMessage> getMessages(int channel_id);

}
