package info.noteme.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import info.noteme.domain.Note;

@Component
public interface NoteDao extends JpaRepository<Note, Long>{
	List<Note> getNoteByUserUsername(String username);
	
}
