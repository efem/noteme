package info.noteme.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import info.noteme.domain.Note;

@Component
public class NoteValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Note.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Note note = (Note)target;
		
		String noteContent = note.getContent();
		
		if (noteContent.length() < 3 || noteContent.length() > 1000) {
			errors.rejectValue("content", "note.content.wronglength");
		}
		
	}

}
