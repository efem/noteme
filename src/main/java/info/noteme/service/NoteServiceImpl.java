package info.noteme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import info.noteme.dao.NoteDao;
import info.noteme.domain.Note;

public class NoteServiceImpl implements NoteService {
	
	@Autowired
	NoteDao noteDao;

	@Override
	public List<Note> findAll() {
		return noteDao.findAll();
	}

	@Override
	public Note getNoteById(Long id) {
		return noteDao.findOne(id);
	}

	@Override
	public Note getNoteByUsername(String username) {
		return noteDao.getNoteByUser(username);
	}

	@Override
	public Note save(Note note) {
		Note noteToSave = note;

		String arr[] = note.getContent().split(" ", 2);
		String nick = arr[0]; 
		if (nick.length() > 0 && nick.length() <= 20) {
			noteToSave.setTrynick(nick);
		} else {
			noteToSave.setTrynick("dummy");
		}
		
		return noteToSave;
	}

}
