package com.example.trainingProject3;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseBody
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = InvalidRequestException.class)
	public ResponseClass throwBadRequestException(InvalidRequestException e) {
		ResponseClass response = new ResponseClass();
		response.setCode("400");
		response.setMessag(e.getMessage());
		return response;
	}

}
