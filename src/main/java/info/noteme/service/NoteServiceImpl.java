package info.noteme.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import info.noteme.dao.NoteDao;
import info.noteme.domain.Note;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class NoteServiceImpl implements NoteService {
	
	static final Logger LOG = LoggerFactory.getLogger(NoteServiceImpl.class);
	
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
			noteToSave.setNickfound(true);
			
		} else {
			noteToSave.setTrynick("dummy");
			noteToSave.setNickfound(false);
		}
	  
		noteToSave.setDateadded(new Date());
		noteToSave.setDatemodified(new Date());
		noteToSave.setMailtosend(false);
		noteToSave.setWasmailsend(false);
		
		LOG.info("NEW NOTE: " + noteToSave);
		
		return noteDao.save(noteToSave);
	}

}
