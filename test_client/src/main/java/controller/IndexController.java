package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	/**�����̨*/
	@RequestMapping("/index")
	public String index(){
		return "pc/login";
	}
	/**�ֻ�web��*/
	@RequestMapping("/mobile")
	public String mobile(){
		return "mobile/index";
	}
}
