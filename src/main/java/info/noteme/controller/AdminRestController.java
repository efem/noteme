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
import org.springframework.web.bind.annotation.RestController;

import info.noteme.dao.UserDao;
import info.noteme.domain.Note;
import info.noteme.domain.Role;
import info.noteme.domain.User;
import info.noteme.helper.UserHelper;
import info.noteme.service.NoteService;
import info.noteme.service.RoleService;
import info.noteme.service.UserService;

//@Controller
@RestController
@RequestMapping("/adminApi")
public class AdminRestController {

	static final Logger LOG = LoggerFactory.getLogger(AdminRestController.class);

	@Autowired
	NoteService noteService;

	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;

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
	//@ResponseBody
	public User getAuthorByUsernameJSON(@PathVariable String username) {
		User user = userService.getUserByUsername(username);
		LOG.info("SHOW_AUTHOR_DETAILS-NAME: " + username);
		LOG.info("SHOW_AUTHOR_DETAILS-USER: " + user);
		return user;

	}
	
	
	@RequestMapping(value = "/toggleUser/{username}")
	@ResponseBody
	public User toggleUserJSON(@PathVariable String username) {
		LOG.info("USERE_TOGGLE: " + username);
		User user = userService.getUserByUsername(username);
		
		if (user.isEnabled()) {
			user.setEnabled(false);
		} else {
			user.setEnabled(true);
		}
		
		userService.save(user);
		User userToggled = userService.getUserByUsername(username);
		
		LOG.info("USER_TOGGLED: " + userToggled);
		return userToggled;
	}
	
	@RequestMapping(value = "/getRoles")
	@ResponseBody
	public List<Role> getRolesJSON() {
		LOG.info("GET ROLES");
		List<Role> roles = new ArrayList<Role>();
		roles = roleService.findAll();
		return roles;
	}
	
	@RequestMapping(value = "/getRolesForUser/{username}")
	//@ResponseBody
	public List<Role> getRolesForUserJSON(@PathVariable String username) {
		LOG.info("GET ROLES FOR USER");
		List<Role> roles = new ArrayList<Role>();
		roles = userService.getUserByUsername(username).getRoles();
		LOG.info("RLS: " + roles.toString());
		return roles;
	}
	
	@RequestMapping(value = "/saveUserForRoles/{username}", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public User saveUserForRolesJSON(@PathVariable("username") String username, @RequestParam(value = "userRoles[]", required = false) String roles[]) {
		User user = userService.getUserByUsername("xxx");
		user = UserHelper.setUserRoles(user, roles, roleService);
		userService.save(user);
		return user;
	}

}
