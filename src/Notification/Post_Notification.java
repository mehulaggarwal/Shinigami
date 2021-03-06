package Notification;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import Create_Channel.Channel;
import Create_Channel.ChannelService;
import login_and_register.User;
import Subscribe.*;

@Controller
public class Post_Notification {

	private static final String UPLOAD_DIRECTORY = "/images";

	@Autowired
	NotificationService notificationService;

	@Autowired
	ChannelService channelService;

	@RequestMapping(value = "/PostMessage/{channelName}/{channelid}.html", method = RequestMethod.GET)
	public ModelAndView PostMessage(@PathVariable("channelName") String channelName,
			@PathVariable("channelid") int channelid, HttpSession session) {
		ModelAndView model = new ModelAndView("PostMessages");
		/*
		 * Notification notifi=new Notification(); notifi.setChannel_name(channelName);
		 */
		Retain retain = new Retain();
		retain.setChannelname(channelName);
		retain.setId(channelid);
		
		session.setAttribute("retain", retain);
		model.addObject("msg", "Channel " + channelName);
		return model;
	}

	@RequestMapping(value = "/PostMessage/{channelname}/message.html", method = RequestMethod.POST)
	public ModelAndView message(@RequestParam("message") String message, @RequestParam CommonsMultipartFile file,
			HttpSession session) throws Exception {
		Retain retain = new Retain();
		retain = (Retain) session.getAttribute("retain");
		PostMessage post = new PostMessage();
		post.setChannel_name(retain.getChannelname());
		post.setChannel_id(retain.getId());

		if (file.isEmpty())
			post.setMessage(message);
		else {
			/*ServletContext context = session.getServletContext();*/
			String path = "D:";
			String filename = file.getOriginalFilename();

			System.out.println(path+ filename);

			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(path + File.separator + filename)));
			stream.write(bytes);
			stream.flush();
			stream.close();
			post.setMessage(message);
			post.setUploaded_file(path+"\\"+filename);
		}
		
		post.setUser((User) session.getAttribute("user"));
		notificationService.create(post);
		ModelAndView model = new ModelAndView("posted");
		return model;
	}

	@RequestMapping(value = "/showlist.html", method = RequestMethod.POST)
	public ModelAndView getAllChannels() {

		ModelAndView model = new ModelAndView("channellist");
		List<Channel> list = new ArrayList<Channel>();
		list = channelService.getAll();
		model.addObject("lists", list);
		return model;
	}

}
