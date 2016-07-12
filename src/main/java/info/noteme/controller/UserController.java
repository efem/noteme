package info.noteme.controller;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import info.noteme.domain.User;
import info.noteme.service.UserService;
import info.noteme.validator.PassValidator;

@Controller
@RequestMapping("/user")
public class UserController {

	static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private PassValidator passValidator;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private	ResourceBundleMessageSource messageSource;
	
	@Autowired
	public UserController(UserService userService) {
		 this.userService = userService;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginForm(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, @ModelAttribute("user") User user, BindingResult result) {
		
		if (error != null) {
			LOG.info("INVALID PASSWORD");
			ObjectError errorObj = new ObjectError("general", messageSource.getMessage("user.login.credentials.bad", null, LocaleContextHolder.getLocale()));
			result.addError(errorObj);
		}

		if (logout != null) {
			LOG.error("LOUT");
		}
		return "loginForm";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegsitrationForm(@ModelAttribute("user") User user) {
		return "registerForm";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String processRegistration(@Valid User user, Errors errors) {
		passValidator.validate(user, errors);
		if (errors.hasErrors()) {
			System.out.println("BLEDY WALIDACJI");
			System.out.println(errors.toString());
			return "registerForm";
		}

		LOG.info("GOT FROM FORM: " + user.getUsername());
		userService.save(user);

		return "redirect:/user/" + user.getUsername();
		//return "redirect:/user/Piotr2";
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String showUserProfile(@PathVariable String username, Model model) {
		model.addAttribute("userProfile", userService.getUserByUsername(username));
		return "profile";
	}
}
