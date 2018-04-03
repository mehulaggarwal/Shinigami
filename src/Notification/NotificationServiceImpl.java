package Notification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Subscribe.MsgNotifiId;

@Service("notificationService")
@Transactional(rollbackFor = Exception.class)
public class NotificationServiceImpl implements NotificationService{

	@Autowired
	NotificationDao notificationDao;
	
	@Override
	public void create(PostMessage notifi) {
		notificationDao.create(notifi);
	}

	@Override
	public void update(PostMessage notifi) {
		notificationDao.update(notifi);
		
	}

	@Override
	public void delete(String message) {
		notificationDao.delete(message);
	}

	@Override
	public List<PostMessage> getMessages(int channel_id) {
		return notificationDao.getMessages(channel_id);
	}

}
