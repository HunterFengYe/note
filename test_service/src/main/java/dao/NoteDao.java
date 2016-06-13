package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import utils.MyBatisDao;

@MyBatisDao
public interface NoteDao {

	void addNote(Map<String, Object> noteMap);

	void delNote(Integer noteId);

	void change(Map<String, Object> noteMap);

	List<Map<String, Object>> myNote(Integer userId);

	List<Map<String, Object>> getNote();

	List<Map<String, Object>> search(@Param("search")String search);

}
