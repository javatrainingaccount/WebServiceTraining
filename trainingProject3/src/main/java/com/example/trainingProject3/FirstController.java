package com.example.trainingProject3;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
@RequestMapping("/first")
public class FirstController {

	private static final String USERNAME = "test";
	private static final String PASSWORD = "123456";

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public String receiveJSONAndSendTextMessage() {
		return "Received JSON Request Data11111111111";
	}

	@RequestMapping("/login")
	public String getLoginPage() {
		return "sample";
	}

	@ResponseBody
	@RequestMapping(value = "/validate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String validateJsonLoginDetails(@RequestBody UserDetails userDetails) {
		System.out.println("username: " + userDetails.getUsername() + ", password: " + userDetails.getPassword()
				+ ", age: " + userDetails.getAge() + ", pincode: " + userDetails.getPincode() + ", mobile: "
				+ userDetails.getMobile());
		Gson gson = new Gson();
		return gson.toJson(userDetails);
	}

	@ResponseBody
	@RequestMapping(value = "/validate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String validateFormLoginDetails(@ModelAttribute UserDetails userDetails) {
		System.out.println("username: " + userDetails.getUsername() + ", password: " + userDetails.getPassword()
				+ ", age: " + userDetails.getAge() + ", pincode: " + userDetails.getPincode() + ", mobile: "
				+ userDetails.getMobile());
		
		if (userDetails.getUsername().equalsIgnoreCase(USERNAME)) {
			System.out.println("user found");
			return "user found";
		} else {
			System.out.println("user not found");
			return "user not found";
		}
	}

	@ResponseBody
	@RequestMapping(value = "/type2/{generate}", method = RequestMethod.GET)
	public String sendStatusUsingControllerAdvice(@PathVariable("generate") String generate)
			throws InvalidRequestException {
		if (generate.equalsIgnoreCase("TRUE")) {
			System.out.println("Generating & throwing exception");
			throw new InvalidRequestException("400", "invalid request");
		} else {
			System.out.println("sending success response");
		}
		return "success";
	}

}
