package info.noteme.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/", "/homepage"})
public class HomeController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String home() {
		return "home";
	}
	

}
