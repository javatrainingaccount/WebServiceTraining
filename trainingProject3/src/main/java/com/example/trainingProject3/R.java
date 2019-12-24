package com.example.trainingProject3;

import org.springframework.beans.factory.annotation.Autowired;

public class R {
	@Autowired
	private Q obj;// instance variable

	public String generateMessage() {
		return "test messag";
	}

	public static void main(String a[]) {
		R rObj = new R();
		String message = rObj.generateMessage();
		rObj.obj = new Q();
		rObj.obj.show(message);
	}

}
