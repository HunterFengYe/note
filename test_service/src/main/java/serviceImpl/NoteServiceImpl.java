package serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import dao.NoteDao;
import service.NoteService;

@Service
public class NoteServiceImpl implements NoteService{
	@Autowired
	private NoteDao dao;

	public void addNote(Map<String, Object> noteMap) {
		// TODO Auto-generated method stub
		dao.addNote(noteMap);
	}

	public void delNote(Integer noteId) {
		// TODO Auto-generated method stub
		dao.delNote(noteId);
	}

	public void change(Map<String, Object> noteMap) {
		// TODO Auto-generated method stub
		dao.change(noteMap);
	}

	public List<Map<String, Object>> myNote(Integer userId) {
		// TODO Auto-generated method stub
		return dao.myNote(userId);
	}

	public List<Map<String, Object>> getNote() {
		// TODO Auto-generated method stub
		return dao.getNote();
	}

	public List<Map<String, Object>> search(String search) {
		// TODO Auto-generated method stub
		return dao.search(search);
	}

}
