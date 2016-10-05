package info.noteme.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import info.noteme.domain.Note;
import info.noteme.service.NoteService;

public class NoteRestController extends NoteController{
	
	static final Logger LOG = LoggerFactory.getLogger(NoteRestController.class);

	@Autowired
	NoteService noteService;
	
	@RequestMapping(value = "/showAdmin")
	public String showAdminPageJSON() {
		
		return "showAdmin";

	}
	
	@RequestMapping(value = "/showOne")
	@ResponseBody
	public Note getSingleNoteJSON(@ModelAttribute("note") Note note) {
		
		note = noteService.getNoteById(1L);
		
		return note;

	}
	
	
	@RequestMapping(value = "/showAll")
	@ResponseBody
	public List<Note> getAllleNotesJSON() {
		
		List<Note> allNotes = new ArrayList<Note>();
		allNotes = noteService.findAll();
		
		LOG.info("ALLCONT");
		return allNotes;

	}


}
