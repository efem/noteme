package info.noteme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import info.noteme.interf.Note;


public interface NoteRepository extends JpaRepository<Note, Long> {
	List<Note> findAllNotes();
	Note findOneNote(long id);
	Note findByUsername(String username);
	List<Note> findNotes(long max, int count);
}
