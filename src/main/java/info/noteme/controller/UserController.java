package info.noteme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.noteme.domain.User;
import info.noteme.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

	private UserRepository userRepository;
	
	@Autowired
	public UserController(UserRepository userRepository) {
		 this.userRepository = userRepository;
	}
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegsitrationForm() {
		return "registerForm";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String processRegistration(User user) {
		userRepository.save(user);
		return "redirect:/user/" + user.getUsername();
	}
}
