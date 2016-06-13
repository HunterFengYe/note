package dao;

import java.util.List;
import java.util.Map;

import utils.MyBatisDao;

@MyBatisDao
public interface TabDao {

	List<Map<String, Object>> search(Map<String, Object> map);

	void addTab(Map<String, Object> map);

	List<Map<String, Object>> getTab();

	void del(Integer tabId);

}
