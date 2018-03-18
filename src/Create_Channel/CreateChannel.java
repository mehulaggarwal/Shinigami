package Create_Channel;

import login_and_register.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CreateChannel {

	@Autowired
	ChannelService channelService;

	@RequestMapping(value = "/createchannel.html", method = RequestMethod.POST)
	public ModelAndView createchannel(@ModelAttribute("Channel1") Channel Channel1, HttpSession session,HttpServletRequest request) {
		Channel1.setUser((User) session.getAttribute("user"));
		User user1 = new User();
		channelService.create(Channel1);
		ModelAndView model = new ModelAndView("Check");
		
		return model;
	}
}
