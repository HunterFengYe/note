package controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.UserService;
import utils.ParamUtils;

@Controller
@RequestMapping("/user/")
public class UserController {
	@Autowired
	private UserService user;
	
	/**µÇÂ¼*/
	@ResponseBody
	@RequestMapping("login")
	public String login(HttpServletRequest request){
		 String phone=request.getParameter("phone");
		 String password=request.getParameter("pwd");
		 if(user.checkPhone(phone)==0){
			 return "0";
		 }
		 Map<String,Object> userMap=user.getUser(phone);
		 if(userMap==null){
			 return "2";
		 }
		 Integer userId=(Integer)userMap.get("user_id");
		 String pwd=(String) userMap.get("user_pwd");
		 if(password.equals(userMap.get("user_pwd"))){
			 return "1";
		 }
		return "3";
	}
	/**×¢²á*/
	@RequestMapping("regist")
	public String regist(HttpServletRequest request){
		String phone=request.getParameter("phone");
	   	String pwd=request.getParameter("pwd");
	   	String grade=request.getParameter("grade");
	   	Map<String,Object> userMap=new HashMap<String,Object>();
	   	userMap.put("phone", phone);
	   	userMap.put("pwd", pwd);
	   	userMap.put("grade", grade);
	   	userMap.put("date", new Date());
	   	user.regist(userMap);
	   	Map<String,Object> map=user.getUser(phone);
		Integer userId=(Integer)map.get("user_id");
		request.getSession().setAttribute("userId", userId);
		return "";
	}
	/**²éÑ¯ÊÖ»úÊÇ·ñ´æÔÚ*/
	@RequestMapping("checkPhone")
	public String checkPhone(HttpServletRequest request){
		String phone=request.getParameter("phone");
		if(user.checkPhone(phone)>0){
			return "";
		}
		return "";
	}
	/**ÍË³öµÇÂ¼*/
	@RequestMapping("logOut")
	public String logOut(HttpServletRequest request){
		request.getSession().setAttribute("userMap",null);
		return "pc/login";
	}

}
