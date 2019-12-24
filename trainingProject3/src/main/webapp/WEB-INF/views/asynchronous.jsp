<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Asynchronous Test Page</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	console.log("communicating asynchronously");
	$(document).ready(function() {
		$("#asynchronous").click(function() {
			
			console.log("about to call /demo/test");
			$.ajax({
				url : "http://localhost:8080/demo/test",
				method : "GET",
				ContentType : "application/json",
				success : function(result) {
					console.log("success1 result: " + result);
				},
				complete : function(xhr, status) {
					console.log("xhr1: " + JSON.stringify(xhr) + ", status: " + status)
				},
				error : function(xhr, status, error) {
					console.log("error1: " + error);
				}
			});

			console.log("about to call /demo/getAudience");
			$.ajax({
				url : "http://localhost:8080/demo/getAudience",
				method : "GET",
				ContentType : "application/json",
				success : function(result) {
					console.log("success2 result: " + result);
				},
				complete : function(xhr, status) {
					console.log("xhr2: " + JSON.stringify(xhr) + ", status: " + status)
				},
				error : function(xhr, status, error) {
					console.log("error2: " + error);
				}
			});

		});
	});
</script>

</script>

</head>
<body>
	<form>
		<input type='button' id='asynchronous' value='asynchronous' />
	</form>
</body>
</html>