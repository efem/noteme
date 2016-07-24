package info.noteme.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.noteme.domain.Note;
import info.noteme.service.NoteService;

@Controller
@RequestMapping("/note")
public class NoteController {
	
	static final Logger LOG = LoggerFactory.getLogger(NoteController.class);
	
	@Autowired
	NoteService noteService;

	@RequestMapping(value="/show/{noteid}", method=RequestMethod.GET)
	public String showSingleNote(@ModelAttribute("note") Note note) {
		return "note";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String showNewNoteForm(@ModelAttribute("note") Note note, BindingResult result) {
		
		return "noteForm";
	}

	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String saveNewNote(@Valid Note note, BindingResult result) {
		noteService.save(note);
		return "redirect:/note/show/" + note.getId();
	}
}
