package info.noteme.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import info.noteme.domain.SimpleNote;
import info.noteme.interf.Note;

@Repository
public class NoteDataSource implements NoteRepository{

	@Override
	public List<Note> findNotes(long max, int count) {
		List<Note> noteList = new ArrayList<Note>();
		noteList.add(new SimpleNote("start", new Date()));
		return noteList;
	}

}
