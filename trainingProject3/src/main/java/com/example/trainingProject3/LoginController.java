package com.example.trainingProject3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loginController")
public class LoginController {

	@RequestMapping(value = "/loginPage")
	public String getLoginPage() {
		return "sample";
	}
	
	@GetMapping(value = "/synchronous")
	public String getSynchronousPage() {
		return "synchronous";
	}

	@GetMapping(value = "/asynchronous")
	public String getASynchronousPage() {
		return "asynchronous";
	}

}
