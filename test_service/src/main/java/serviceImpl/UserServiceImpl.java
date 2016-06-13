package serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao dao;

	public Map<String, Object> getUser(String phone) {
		// TODO Auto-generated method stub
		return dao.getUser(phone);
	}

	public void regist(Map<String, Object> userMap) {
		// TODO Auto-generated method stub
		dao.regist(userMap);
	}

	public int checkPhone(String phone) {
		// TODO Auto-generated method stub
		return dao.checkPhone(phone);
	}

}
