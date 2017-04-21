package info.noteme.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	static final Logger LOG = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping(value = "/show")
	public String showAdminPage() {

		LOG.info("SHOW MAIN ADMIN PAGE");
		return "showAdmin";

	}
}
