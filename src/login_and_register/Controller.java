package login_and_register;

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
	
	@RequestMapping(value="/pubsub.html",method=RequestMethod.GET)
	public ModelAndView getFirstPage(){
		 
		ModelAndView model=new ModelAndView("LoginAndRegister");
		return model;
	}
	@RequestMapping(value="/register.html",method=RequestMethod.POST)
	public ModelAndView Register(@ModelAttribute("User1") User User1,HttpSession session)
	{
		userService.create(User1);
		ModelAndView model=new ModelAndView("Check");
		return model;
	}
	@RequestMapping(value="/login.html",method=RequestMethod.POST)
	public ModelAndView Login(@ModelAttribute("User1")User LoginUser,HttpSession session)
	{
	  User user2=new User();
	  user2=userService.get(LoginUser.getEmail());
	  System.out.println("hello");
	  /*System.out.println(user2.getPassword());
	  System.out.println(user2.getEmail());
	  System.out.println(User1.getPassword());*/
	  if(user2==null)
	  {
		  return new ModelAndView("LoginUnsuccess");
	  }
	  String s1=user2.getPassword();
	  String s2=LoginUser.getPassword();
	  if(!s1.equals(s2))
	  {
		  return new ModelAndView("LoginUnsuccess");
	  }
	  
	return new ModelAndView("LoginSuccess");
	}
}
