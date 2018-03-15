package Create_Channel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("channelService")
@Transactional(rollbackFor=Exception.class)
public class ChannelServiceImpl implements ChannelService{

	@Autowired
	ChannelDao channelDao;
	
	@Override
	public void create(Channel Channel1) {
	   channelDao.create(Channel1);
	}

	@Override
	public void update(Channel Channel1) {
		channelDao.update(Channel1);
		
	}

	@Override
	public void delete(String channel_name) {
		channelDao.delete(channel_name);
		
	}

	@Override
	public Channel find(String channel_name) {
		return channelDao.find(channel_name);
	}

	@Override
	public List<Channel> getAll() {
		return channelDao.getAll();
	}

	@Override
	public Channel edit(String channel_name) {
		return channelDao.edit(channel_name);
	}

}
