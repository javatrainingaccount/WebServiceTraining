package com.example.trainingProject3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("/demo")
public class ConsumesController {

	private Map<String, String> tempCache = new HashMap<String, String>();

	@Autowired
	private Environment env;

	@Value("${first.name}")
	private String firstName;

	@GetMapping("/getAudience")
	public String readProperties() {
		System.out.println("starting of readProperties method");
		/*
		 * try { Thread.sleep(10 * 1000); } catch (Exception e) { // TODO: handle
		 * exception }
		 */
		return env.getProperty("first.name");
		// return sb.toString();
	}

	@GetMapping("/test")
	public String testMethod() {
		try {
			Thread.sleep(15000);
		} catch (Exception e) {
		}
		return "success";
	}

	@PostMapping(value = "/emp/{name}")
	public String createUser(
			/* @PathParam("name") Employee emp, @PathVariable("name") String name */@RequestBody Employee emp) {
		try {
			Random random = new Random();
			// System.out.println("name from @PathVariable: " + name);
			System.out.println("creating new emp with name: " + emp.getName() + ", age: " + emp.getAge() + ", phone: "
					+ emp.getPhone());
			String empId = String.valueOf(random.nextLong());
			tempCache.put(empId, emp.getName());// creating a user with the given name
			System.out.println("tempCache: " + tempCache);
			return empId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@PutMapping(value = "/emp/{name}")
	public String updateUser(
			/* @PathParam("name") Employee emp, @PathVariable("name") String name */@RequestBody Employee emp) {
		try {
			Random random = new Random();
			// System.out.println("name from @PathVariable: " + name);
			System.out.println("updating emp with name: " + emp.getName() + ", age: " + emp.getAge() + ", phone: "
					+ emp.getPhone());
			String empId = String.valueOf(random.nextLong());
			tempCache.put(empId, emp.getName());// creating a user with the given name
			System.out.println("tempCache: " + tempCache);
			return empId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@PatchMapping(value = "/emp/{name}")
	public String updateUser(
			/* @PathParam("name") Employee emp, @PathVariable("name") String name */@RequestBody Map<String, String> emp) {
		try {
			Random random = new Random();
			// System.out.println("name from @PathVariable: " + name);
			System.out.println("to be updated data: " + emp);
			String empId = String.valueOf(random.nextLong());
			// tempCache.put(empId, emp.getName());// creating a user with the given name
			System.out.println("tempCache: " + tempCache);
			return empId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@PutMapping(value = "/emp/{id}/{name}/{hasUpdatedProfileToday1}")
	public Object updateUser(@PathVariable("name") String name, @PathVariable("id") String id,
			@PathVariable("hasUpdatedProfileToday1") String hasUpdatedProfileToday1) {
		System.out.println("before update: " + tempCache);
		if (tempCache.containsKey(id)) {
			System.out.println("Employee already existed");
			// boolean hasUpdatedProfileToday = false;
			boolean hasUpdatedProfileToday = Boolean.parseBoolean(hasUpdatedProfileToday1);
			if (!hasUpdatedProfileToday) {
				// ill allow him to do update
				System.out.println("updating user profile");
			} else {
				// ill reject
				System.out.println(
						"user has already updated his profile once today, hence rejecting and informing the user to wait till next day");
				return "failed";
			}
		} else {
			System.out.println("creating employee record");
		}
		tempCache.put(id, name);
		System.out.println("tempCache: " + tempCache);
		return "success";
	}

	@DeleteMapping(value = "/emp/{name}")
	public String deleteUser(@PathVariable("name") String id) {
		if (tempCache.containsKey(id)) {
			tempCache.remove(id);
			return "success";
		} else {
			System.out.println("Invalid id");
			return "failed";
		}
	}

	@GetMapping(value = "/alpha", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public String receiveJSONAndSendTextMessage(@RequestParam("name") String name) {
		System.out.println("start time: " + System.currentTimeMillis());
		Gson gson = new Gson();
		Employee emp = new Employee();
		emp.setName("praveen");
		emp.setAge("23");
		System.out.println("name: " + name);

		try {
			Thread.sleep(15000);
		} catch (Exception e) {
		}

		System.out.println("end time: " + System.currentTimeMillis());
		return gson.toJson(emp);
	}

	@GetMapping(value = { "/alpha", "/beta", "/gamma" }, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_PDF_VALUE }/*
												 * , produces = { MediaType.APPLICATION_JSON_VALUE,
												 * MediaType.APPLICATION_PDF_VALUE }
												 */)
	public String receiveXMLAndSendTextMessage(HttpServletRequest req) {
		System.out.println("content type: " + req.getContentType());
		try {
			Thread.sleep(15000);
		} catch (Exception e) {
		}
		Employee emp = new Employee();
		emp.setName("teja");
		emp.setAge("24");
		return emp.toString();
	}
}
