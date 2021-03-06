package info.noteme.service;

import java.util.List;

import info.noteme.domain.Note;

public interface NoteService {
	List<Note> findAll();
	
	Note getNoteById(Long id);
	
	List<Note> getNoteByUserUsername(String username);
	
	Note save(Note note);
}
