package info.noteme.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import info.noteme.domain.SimpleNote;
import info.noteme.interf.Note;

@Repository
public class NoteDataSource implements NoteRepository{
	private static List<Note> noteList = new ArrayList<Note>();
	private static void fillNoteList() {
		for (int i=0; i<20; i++) {
			noteList.add(new SimpleNote(Long.getLong("i"), i + "-ta notatka", new Date()));
		}
	}
	
	
	@Override
	public List<Note> findNotes(long max, int count) {	
		if (noteList.isEmpty())
			fillNoteList();
		return noteList;
	}

	@Override
	public Note findOneNote(long id) {
		if (noteList.isEmpty())
			fillNoteList();
		return noteList.get(Integer.parseInt(String.valueOf(id)));
	}

}
