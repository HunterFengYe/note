package service;

import java.util.Map;

public interface UserService {


	public Map<String, Object> getUser(String phone);

	public void regist(Map<String, Object> userMap) ;

	public int checkPhone(String phone) ;

}
