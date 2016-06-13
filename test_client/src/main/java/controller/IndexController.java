package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	/**管理后台*/
	@RequestMapping("/index")
	public String index(){
		return "pc/login";
	}
	/**手机web端*/
	@RequestMapping("/mobile")
	public String mobile(){
		return "mobile/index";
	}
}
