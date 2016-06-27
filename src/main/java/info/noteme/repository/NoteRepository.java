package info.noteme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import info.noteme.interf.Note;


public interface NoteRepository {
	List<Note> findNotes(long max, int count);
}
