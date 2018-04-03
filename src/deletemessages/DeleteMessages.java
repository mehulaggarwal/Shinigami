package deletemessages;
import login_and_register.*;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeleteMessages {

	@Autowired
	DeleteService deleteService;
	
	@RequestMapping(value="/deleteMessage/{channel_name}/{channelid}/{Notificationid}.html")
	public ModelAndView deleteMessage(@PathVariable("channel_name")String channel_name, @PathVariable("channelid")int channel_id,@PathVariable("Notificationid")int Notification_id,HttpSession session) {
		
		Delete delete=new Delete();
		delete.setChannel_id(channel_id);
		delete.setNotification_id(Notification_id);
		delete.setUser((User)session.getAttribute("user"));
		deleteService.create(delete);
       return new ModelAndView("redirect:/showMessages/{channel_name}/{channelid}.html");
	}

}
