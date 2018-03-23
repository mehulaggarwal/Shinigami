package login_and_register;

import Create_Channel.*;
import Subscribe.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	UserService userService;

	@Autowired
	ChannelService channelService;
	
     @Autowired
     SubscriberService subscriberService;
	
	@RequestMapping(value = "/pubsub.html", method = RequestMethod.GET)
	public ModelAndView getFirstPage() {

		ModelAndView model = new ModelAndView("LoginAndRegister");
		return model;
	}

	@RequestMapping(value = "/register.html", method = RequestMethod.POST)
	public ModelAndView Register(@ModelAttribute("User1") User User1, HttpSession session) {
		userService.create(User1);
		ModelAndView model = new ModelAndView("LoginSuccess");
		return model;
	}

	@RequestMapping(value = "/login.html", method = RequestMethod.POST)
	public ModelAndView Login(@ModelAttribute("User1") User LoginUser, HttpSession session,
			HttpServletRequest request) {
		User user2 = new User();
		user2 = userService.get(LoginUser.getEmail());
		if (user2 == null) {
			return new ModelAndView("LoginUnsuccess") ;
		}
		session.setAttribute("user", user2);
		String s1 = user2.getPassword();
		String s2 = LoginUser.getPassword();
		if (!s1.equals(s2)) {
			return new ModelAndView("LoginUnsuccess") ;
		}
		List<Channel> list = new ArrayList<Channel>();
		ModelAndView model=new ModelAndView("LoginSuccess");
		list = channelService.getChannelNames(user2.getUser_id());
		model.addObject("lists", list);
		
		List<Subscriber> list1=new ArrayList<Subscriber>();
		list1=subscriberService.getSubscribedChannels(user2.getUser_id());
		model.addObject("lists1",list1);
		return model;
		
		
	}
	@RequestMapping(value="/logout.html",method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response){
		request.getSession().invalidate();
	    return new ModelAndView("redirect:/pubsub.html");
	}

}
