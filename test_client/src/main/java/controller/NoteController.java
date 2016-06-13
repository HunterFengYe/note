package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utils.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import service.NoteService;
import utils.ParamUtils;

@Controller
@RequestMapping("/note/")
public class NoteController {
	@Autowired
	private NoteService note;
	/**新建笔记*/
	@RequestMapping("addNote")
	public String addNote(@RequestParam("select-photo")MultipartFile[] files,HttpServletRequest request) throws IOException{     
		Map userMap=(Map)request.getSession().getAttribute("userMap");
		Integer userId=(Integer) userMap.get("user_id");
		String title=request.getParameter("title");
		String tab=request.getParameter("tab");
		String body=request.getParameter("body");
		String own=request.getParameter("own");
		String imgName=new String();
		Map<String,Object> noteMap=new HashMap<String,Object>();
		if(files!=null&&files.length>0){
	  		  if(files.length==1&&files[0].isEmpty()){
	  			  imgName=null;
	  		  
	  		  }
	  			for(int i=0;i<files.length;i++){
	  				MultipartFile file=files[i];
	  				if (!file.isEmpty()) {  
	  	                try {  
	  	                    // 文件保存路径  
	  	                    String filePath = request.getSession().getServletContext().getRealPath("/image/note/");  
	  	                    // 转存文件  
	  	                    file.transferTo(new File(filePath,file.getOriginalFilename())); 
	  	                    imgName+=file.getOriginalFilename();
	  	                } catch (Exception e) {  
	  	                    e.printStackTrace();  
	  	                }
	  	                
	  	            }  
	  			}
	  			
	  		noteMap.put("own", own);
	  	    noteMap.put("userId", userId);
	  	    noteMap.put("title",title);
	  	    noteMap.put("tab", tab);
	  	    noteMap.put("body", body);
	  	    noteMap.put("imgName", imgName);
	  	    noteMap.put("date", new Date());
	  	    note.addNote(noteMap);
		
	    }
		List<Map<String,Object>> noteList=note.getNote();
		request.setAttribute("noteList", noteList);
		return "pc/index";
	}
	/**删除笔记*/
	@RequestMapping("delNote")
	public String delNote(HttpServletRequest request){
		Integer noteId=ParamUtils.paramInt(request, "noteId");
		note.delNote(noteId);
		List<Map<String,Object>> noteList=note.getNote();
		request.setAttribute("noteList", noteList);
		return "pc/index";
	}
	/**修改笔记*/
	@RequestMapping("change")
	public String change(HttpServletRequest request){
		Integer userId=(Integer)request.getSession().getAttribute("userId");
		Integer noteId=ParamUtils.paramInt(request, "noteId");
		String title=request.getParameter("title");
		String tab=request.getParameter("tab");
		String body=request.getParameter("body");
		Map<String,Object> noteMap=new HashMap<String,Object>();
		noteMap.put("userId", userId);
  	    noteMap.put("title",title);
  	    noteMap.put("tab", tab);
  	    noteMap.put("body", body);
  	    noteMap.put("date", new Date());
  	    note.change(noteMap);
  	    return "";
	}
	/**显示笔记*/
	@RequestMapping("myNote")
	public String myNote(HttpServletRequest request){
		Integer userId=(Integer)request.getSession().getAttribute("userId");
		List<Map<String,Object>> noteMap=note.myNote(userId);
		return "";
	}
	/**搜索笔记*/
	@ResponseBody
	@RequestMapping("search")
	public void search(HttpServletRequest request,HttpServletResponse response){
		String search=request.getParameter("search");
		List<Map<String,Object>> list=note.search(search);
		String json=StringUtils.json(list);
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out;
    	try {
			out = response.getWriter();
			out.print(json);
			out.flush();
		     out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
