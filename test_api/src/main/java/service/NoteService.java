package service;

import java.util.Map;

import java.util.List;


public interface NoteService {

	public void addNote(Map<String, Object> noteMap);

	public void delNote(Integer noteId);

	public void change(Map<String, Object> noteMap) ;

	public List<Map<String, Object>> myNote(Integer userId) ;

	public List<Map<String, Object>> getNote() ;

	public List<Map<String, Object>> search(String search);

}
