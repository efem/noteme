package info.noteme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import info.noteme.domain.Note;
import info.noteme.domain.User;

@Controller
@RequestMapping("/note")
public class NoteController {

	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String showNewNoteForm(@ModelAttribute("note") Note note, BindingResult result) {
		
		return "noteForm";
	}

}
