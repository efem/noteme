package info.noteme.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import info.noteme.domain.Note;
import info.noteme.service.NoteService;

@Controller
@RequestMapping("/admin")
public class AdminRestController {

	static final Logger LOG = LoggerFactory.getLogger(AdminRestController.class);

	@Autowired
	NoteService noteService;

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
		LOG.info("SHOW ONE NOTE BY USERNAME" + username);
		return notesByUser;

	}

}
