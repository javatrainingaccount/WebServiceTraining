package com.example.trainingProject3;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exception")
public class ThrowExceptionController {

	@ResponseBody
	@RequestMapping(value = "/type1/{generate}/{generate2}", method = RequestMethod.GET)
	public ResponseEntity sendStatusUsingResponseEntity(@PathVariable("generate") String generate) {
		ResponseEntity entity = null;
		new ResponseEntity(HttpStatus.OK);
		
		if (generate.equalsIgnoreCase("TRUE")) {
			System.out.println("Generating & throwing exception");
			entity = new ResponseEntity("failed", HttpStatus.UNSUPPORTED_MEDIA_TYPE);
			// throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
		} else {
			System.out.println("sending success response");
			entity = new ResponseEntity("success", HttpStatus.OK);
		}
		
		return entity;
	}
}
