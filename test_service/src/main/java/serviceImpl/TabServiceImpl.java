package serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TabDao;
import service.TabService;

@Service
public class TabServiceImpl implements TabService {
	@Autowired
	private TabDao tabDao;

	public List<Map<String, Object>> search(Map<String, Object> map) {
		// TODO Auto-generated method stub
		 return tabDao.search(map);
	}

	public void addTab(Map<String, Object> map) {
		// TODO Auto-generated method stub
		tabDao.addTab(map);
	}

	public List<Map<String, Object>> getTab() {
		// TODO Auto-generated method stub
		return tabDao.getTab();
	}

	public void del(Integer tabId) {
		// TODO Auto-generated method stub
		tabDao.del(tabId);
	}

}
