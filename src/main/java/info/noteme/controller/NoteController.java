package info.noteme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import info.noteme.domain.Note;

@Controller
@RequestMapping("/notes")
public class NoteController {
	private static final String MAX_LONG_AS_STRING = "10";
	/*@Autowired
	private NoteRepository noteRepository;

	@Autowired
	public NoteController(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String notes(Model model) {
		model.addAttribute("noteList", noteRepository.findNotes(Long.MAX_VALUE, 20));
		return "notes";
	}*/

/*	@RequestMapping(method = RequestMethod.GET)
	public List<Note> notes(@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
			@RequestParam(value = "count", defaultValue = "10") int count) {
		return noteRepository.findNotes(max, count);
	}*/

	/*@RequestMapping(value = "/{noteId}", method = RequestMethod.GET)
	public String showNote(@PathVariable long noteId, Model model) {
		model.addAttribute("showNote", noteRepository.findOne(noteId));
		return "note";
	}*/

}
