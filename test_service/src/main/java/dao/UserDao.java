package dao;

import java.util.Map;

import utils.MyBatisDao;

@MyBatisDao
public interface UserDao {

	Map<String, Object> getUser(String phone);

	void regist(Map<String, Object> userMap);

	int checkPhone(String phone);

}
