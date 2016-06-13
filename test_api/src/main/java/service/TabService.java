package service;

import java.util.List;
import java.util.Map;



public interface TabService {


	public List<Map<String, Object>> search(Map<String, Object> map) ;

	public void addTab(Map<String, Object> map) ;

	public List<Map<String, Object>> getTab();

	public void del(Integer tabId) ;

}
