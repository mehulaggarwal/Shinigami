package Create_Channel;

import java.util.List;

public interface ChannelService {

	public void create(Channel Channel1);

	public void update(Channel Channel1);

	public void delete(String channel_name);

	public Channel find(String channel_name);

	public List<Channel> getAll();

	public Channel edit(String channel_name);
	
	public List<String> getChannelNames(int user_id);
}
