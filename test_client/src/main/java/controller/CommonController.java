package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.NoteService;
import service.TabService;
import service.UserService;

@Controller
@RequestMapping("/common/")
public class CommonController {
	@Autowired(required=true)
	private UserService user;
	@Autowired(required=true)
	private NoteService note;
	@Autowired(required=true)
	private TabService tab;
	
	public UserService getUserService(){
		return user;
	}
	@RequestMapping("toIndex")
	public String toIndex(HttpServletRequest request){
		String phone=request.getParameter("phone");
		Map<String,Object> userMap=user.getUser(phone);
		List<Map<String,Object>> noteList=note.getNote();
		request.getSession().setAttribute("userMap", userMap);
		request.getSession().setAttribute("userId", userMap.get("user_id"));
		request.setAttribute("noteList", noteList);
		return "pc/index";
	}
	@RequestMapping("toTab")
	public String index(HttpServletRequest request){
		List<Map<String,Object>> tabList=tab.getTab();
		request.setAttribute("tabList", tabList);
		return "pc/tab";
	}

}
