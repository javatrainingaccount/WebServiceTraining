<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#login").click(function() {
			alert("clicked");

			let username = $("#username").val();
			let password = $("#password").val();

			$.ajax({
				url : "http://localhost:8080/first/validate",
				type : "POST",
				ContentType : "application/json",
				data : {
					"username" : username,
					"password" : password
				},
				success : function(result) {
					alert("result: " + result)
				}
			});

		});
	});
</script>
</head>
<body>
	<h2>Welcome to Java Training Login Page</h2>
	<form action="/first/validate" method="POST"
		enctype="application/x-www-form-urlencoded">
		username: <input type='text' id='username' name='username' /><br>
		password:<input type='password' id="password" name='password' /><br>
		<!-- <input type='submit' value='Login' id='login'/> -->
		age: <input type='text' id='age' name='age' /><br>
		phone number: <input type='text' id='phone' name='phone' /><br>
		location: <input type='text' id='location' name='location' /><br>
		<input type='button' value='Login' id='login' />
	</form>
</body>
</html>