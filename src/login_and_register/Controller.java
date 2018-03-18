package login_and_register;

import Create_Channel.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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

	@RequestMapping(value = "/pubsub.html", method = RequestMethod.GET)
	public ModelAndView getFirstPage() {

		ModelAndView model = new ModelAndView("LoginAndRegister");
		return model;
	}

	@RequestMapping(value = "/register.html", method = RequestMethod.POST)
	public ModelAndView Register(@ModelAttribute("User1") User User1, HttpSession session) {
		userService.create(User1);
		ModelAndView model = new ModelAndView("Check");
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
		List<String> list = new ArrayList<String>();
		ModelAndView model=new ModelAndView("LoginSuccess");
		list = channelService.getChannelNames(user2.getUser_id());
		model.addObject("lists", list);
		System.out.println("hello");
		return model;
	}

}
