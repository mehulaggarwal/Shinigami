package Subscribe;
import login_and_register.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import Notification.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SubscribeChannel {
  @Autowired
  SubscriberService subscriberService;
  
  @Autowired
  NotificationService notificationService;
  
	@RequestMapping(value="/subscribeChannel/{channelname}/{channelid}")
	public ModelAndView subscribe(@PathVariable("channelname")String channelname,@PathVariable("channelid") int channelid,HttpSession session){
		
		Subscriber person=new Subscriber();
		person.setChannel_id(channelid);
		person.setChannel_name(channelname);
		person.setUser((User)session.getAttribute("user"));
		subscriberService.create(person);
		ModelAndView model=new ModelAndView("subscribed");
		return model;
	}
	
	@RequestMapping(value="/showMessages/{channelname}/{channelid}.html",method=RequestMethod.GET)
	public ModelAndView getMessages(@PathVariable("channelname")String channelname,@PathVariable("channelid") int channelid)
	{
		ModelAndView model=new ModelAndView("messages");
		List<String> messages=new ArrayList<String>();
		messages=notificationService.getMessages(channelid);
		model.addObject("messages",messages);
		return model;
	}
}
