package org.oni.webapp.controller;
import org.oni.webapp.controller.abstracts.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * It is a controller that performs the login process for the application.
 * 
 * @author DungTV
 */
@Controller
@RequestMapping(value="/admin/")
public class LoginController extends AbstractController {
	/** View name */
	private static final String	VIEW_NAME	="admin/Login";
	/**
	 * display the login screen.
	 * 
	 * @return View name
	 */
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login() {
		return VIEW_NAME;
	}
	/**
	 * display the login screen to login failure.
	 * 
	 * @param model
	 *          Map is used to store the data to be passed to the view
	 * @return View name
	 */
	@RequestMapping(value="loginfailed", method=RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error","true");
		return VIEW_NAME;
	}
	/**
	 * display the login screen after logging out.
	 * 
	 * @return View name
	 */
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout() {
		return VIEW_NAME;
	}
}
