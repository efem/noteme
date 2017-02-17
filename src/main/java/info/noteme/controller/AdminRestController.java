package info.noteme.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import info.noteme.dao.UserDao;
import info.noteme.domain.Note;
import info.noteme.domain.User;
import info.noteme.service.NoteService;
import info.noteme.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminRestController {

	static final Logger LOG = LoggerFactory.getLogger(AdminRestController.class);

	@Autowired
	NoteService noteService;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/showAdmin")
	public String showAdminPageJSON() {

		LOG.info("SHOW MAIN ADMIN PAGE");
		return "showAdmin";

	}

	@RequestMapping(value = "/showOne")
	@ResponseBody
	public Note getSingleNoteJSON(@ModelAttribute("note") Note note) {

		note = noteService.getNoteById(1L);
		LOG.info("SHOW ONE NOTE");
		return note;

	}

	@RequestMapping(value = "/showAll")
	@ResponseBody
	public List<Note> getAllleNotesJSON() {

		List<Note> allNotes = new ArrayList<Note>();
		allNotes = noteService.findAll();

		LOG.info("SHOW ALL NOTES");
		return allNotes;

	}

	@RequestMapping(value = "/showByAuthor/{username}")
	@ResponseBody
	public List<Note> getNoteByUserJSON(@PathVariable String username) {

		LOG.info("USNAME" + username);
		List<Note> notesByUser = noteService.getNoteByUserUsername(username);

		return notesByUser;

	}

	@RequestMapping(value = "/showAuthorDetails/{username}")
	@ResponseBody
	public User getAuthorByUsernameJSON(@PathVariable String username) {
		User user = userService.getUserByUsername(username);
		LOG.info("USRNAME: " + username);
		LOG.info("USYR: " + user);
		return user;

	}
	
	/*@RequestMapping(value = "/toggleUser", method=RequestMethod.POST)
	@ResponseBody
	//public User toggleUserJSON(@RequestBody String username) {
	public User toggleUserJSON(@RequestBody String username) {
		LOG.info("USRNAME_TOGGLE: " + username);
		User user = userService.getUserByUsername(username);
		
		LOG.info("USR_TOGGLE: " + user);
		return user;
	}*/
	
	
	@RequestMapping(value = "/toggleUser/{username}")
	@ResponseBody
	public User toggleUserJSON(@PathVariable String username) {
		LOG.info("USRNAME_TOGGLE: " + username);
		User user = userService.getUserByUsername(username);
		
		if (user.isEnabled()) {
			user.setEnabled(false);
		} else {
			user.setEnabled(true);
		}
		
		userService.save(user);
		User userToggled = userService.getUserByUsername(username);
		
		LOG.info("USR_TOGGLE: " + userToggled);
		return userToggled;
	}

}
