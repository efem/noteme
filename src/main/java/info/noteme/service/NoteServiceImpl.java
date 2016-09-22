package info.noteme.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import info.noteme.dao.NoteDao;
import info.noteme.dao.UserDao;
import info.noteme.domain.Note;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class NoteServiceImpl implements NoteService {
	
	static final Logger LOG = LoggerFactory.getLogger(NoteServiceImpl.class);
	
	@Autowired
	NoteDao noteDao;
	
	@Autowired
	UserDao userDao;

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
		LOG.info("Saving note");
		
		noteToSave.setDateadded(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
		noteToSave.setDatemodified(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
		noteToSave.setMailtosend(false);
		noteToSave.setWasmailsend(false);
		
		if (note.getUser()==null || note.getUser().equals("")) {
			String arr[] = note.getContent().split(" ", 2);
			String nick = arr[0]; 
			if (nick.length() > 0 && nick.length() <= 20 && arr.length > 1) {
				LOG.info("Trynick from Note: " + nick);
				noteToSave.setTrynick(nick);
				if (userDao.getUserByUsername(nick)!=null){
					noteToSave.setTrynick(userDao.getUserByUsername(nick).getUsername());
					noteToSave.setNickfound(true);
				} else {
					noteToSave.setTrynick(nick);
					noteToSave.setNickfound(false);
				}		
			} else {
				noteToSave.setTrynick("-not applicable-");
				noteToSave.setNickfound(false);
			}
		} else {
			noteToSave.setTrynick("");
			noteToSave.setNickfound(false);
			noteToSave.setMailtosend(true);
		}	
		
		LOG.info("NEW NOTE: " + noteToSave);
		
		return noteDao.save(noteToSave);
	}

}
