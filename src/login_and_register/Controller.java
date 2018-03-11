package login_and_register;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {

	@RequestMapping(value="/pubsub.html",method=RequestMethod.GET)
	public ModelAndView getFirstPage(){
		 
		ModelAndView model=new ModelAndView("LoginAndRegister");
		return model;
	}
}
