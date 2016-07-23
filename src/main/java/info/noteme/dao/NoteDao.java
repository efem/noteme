package info.noteme.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import info.noteme.domain.Note;

@Component
public interface NoteDao extends JpaRepository<Note, Long>{
	Note getNoteByUser(String username);
	
}
