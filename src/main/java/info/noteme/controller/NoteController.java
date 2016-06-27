package info.noteme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.noteme.repository.NoteRepository;

@Controller
@RequestMapping("/notes")
public class NoteController {
	@Autowired
	private NoteRepository noteRepository;
	
	@Autowired
	public NoteController (NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String notes(Model model) {
		model.addAttribute("noteList", noteRepository.findNotes(Long.MAX_VALUE, 20));
		return "notes";
	}
	
}
