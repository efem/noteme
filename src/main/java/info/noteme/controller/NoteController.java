package info.noteme.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.MappedSuperclass;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import info.noteme.domain.Note;
import info.noteme.domain.User;
import info.noteme.service.NoteService;
import info.noteme.service.UserService;
import info.noteme.validator.NoteValidator;

@Controller
@RequestMapping("/note")
public class NoteController {

	static final Logger LOG = LoggerFactory.getLogger(NoteController.class);

	@Autowired
	NoteService noteService;

	@Autowired
	UserService userService;

	@Autowired
	NoteValidator noteValidator;

	@RequestMapping(value = "/show/{noteid}", method = RequestMethod.GET)
	public String showSingleNote(@PathVariable int noteid, Model model) {
		Long noteId = ((Integer) noteid).longValue();
		LOG.info("NOTEID: " + noteId + " CLASS: " + noteId.getClass().getName());
		model.addAttribute("singleNote", noteService.getNoteById(noteId));

		return "note";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String showNewNoteForm(@ModelAttribute("note") Note note, BindingResult result) {

		return "noteForm";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String saveNewNote(@Valid Note note, Errors errors, Principal principal) {
		noteValidator.validate(note, errors);

		if (errors.hasErrors()) {
			LOG.error("VALIDATION ERRORS: " + errors.toString());
			return "noteForm";
		}
		try {
			LOG.info("PRINCIPAL: " + principal.getName());
			note.setUser(userService.getUserByUsername(principal.getName()));
		} catch (NullPointerException npe) {
			LOG.info("PRICIPAL: not logged in");
		}

		noteService.save(note);
		return "redirect:/note/show/" + note.getId();
	}

	
}
