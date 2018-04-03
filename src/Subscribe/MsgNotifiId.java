package Subscribe;

public class MsgNotifiId {

	private int Notification_id;
	
	private String message;
	
	public int channel_id;

	public int getNotification_id() {
		return Notification_id;
	}

	public void setNotification_id(int notification_id) {
		Notification_id = notification_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(int channel_id) {
		this.channel_id = channel_id;
	}
	
	
}
