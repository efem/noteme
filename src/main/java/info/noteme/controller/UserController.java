package info.noteme.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.noteme.domain.User;
import info.noteme.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		 this.userService = userService;
	}
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegsitrationForm(@ModelAttribute("user") User user) {
		return "registerForm";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String processRegistration(@Valid User user, Errors errors) {
		if (errors.hasErrors()) {
			System.out.println("BLEDY WALIDACJI");
			System.out.println(errors.toString());
			return "registerForm";
		}
		System.out.println("GOT FROM FORM: " + user.getUsername());
		userService.save(user);
		return "redirect:/user/" + user.getUsername();
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String showUserProfile(@PathVariable String username, Model model) {
		model.addAttribute("userProfile", userService.getUserByUsername(username));
		return "profile";
	}
}
