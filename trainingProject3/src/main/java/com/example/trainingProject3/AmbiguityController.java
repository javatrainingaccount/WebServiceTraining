package com.example.trainingProject3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ambiguity")
public class AmbiguityController {

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public String receiveJSONAndSendTextMessage() {
		return "Received JSON Request Data";
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public String receiveXMLAndSendTextMessage() {
		return "Received XML Request Data";
	}

}
