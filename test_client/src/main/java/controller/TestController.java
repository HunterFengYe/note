package controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.TestService;

@Controller
public class TestController {
	@Autowired
	private TestService test;
	@RequestMapping("/test")
	public void test(){
		test.sayHello();
	}

}
