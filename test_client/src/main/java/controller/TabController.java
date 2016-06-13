package controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.TabService;
import utils.ParamUtils;

@Controller
@RequestMapping("/tab/")
public class TabController {
	@Autowired
	private TabService tab;
	
	/**搜索标签*/
	@ResponseBody
	@RequestMapping("search")
	public String search(HttpServletRequest request){
		Integer tabId=ParamUtils.paramInt(request, "tabId");
		Integer sub=ParamUtils.paramInt(request, "sub");
		Integer grade=ParamUtils.paramInt(request, "grade");
		Integer chapter=ParamUtils.paramInt(request, "chapter");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("tabId", tabId);
		map.put("sub", sub);
		map.put("grade", grade);
		map.put("chapter", chapter);
		List<Map<String,Object>> list=tab.search(map);
		return "";
	}
	/**新增标签*/
	@ResponseBody
	@RequestMapping("addTab")
	public String addTab(HttpServletRequest request){
		Integer userId=(Integer) request.getSession().getAttribute("userId");
		String tabName=request.getParameter("tab");
		Integer sub=ParamUtils.paramInt(request, "sub");
		Integer book=ParamUtils.paramInt(request, "book");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userId", userId);
		map.put("sub", sub);
		map.put("book", book);
		map.put("tabName", tabName);
		map.put("date", new Date());
		tab.addTab(map);
		return "1";
	}
	/**删除标签*/
	@RequestMapping("del")
	public String del(HttpServletRequest request){
		Integer tabId=ParamUtils.paramInt(request, "tabId");
		tab.del(tabId);
		List<Map<String,Object>> tabList=tab.getTab();
		request.setAttribute("tabList", tabList);
		return "pc/tab";
	}

}
