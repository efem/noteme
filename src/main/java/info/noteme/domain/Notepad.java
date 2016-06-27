package info.noteme.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import info.noteme.interf.Note;
import info.noteme.interf.Notebook;

@Component
public class Notepad implements Notebook {
	private Note note;
	
	@Autowired
	public Notepad(Note note) {
		this.note = note;
	}
	
	public void printNote(){
		
	}
}
