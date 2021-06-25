<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Register User</h3>
		<%
		String errorMessage=(String) session.getAttribute("errorMessage") ;
		if (errorMessage != null) {
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
		%>
		<form method="post" onsubmit="registerUser()">
			<label for="username">User Name</label> <br /> <input type="text"
				name="username" id="username" placeholder="Enter user name" required
				autofocus /> <br /> <br /> <label for="password">Password</label><br />
			<input type="password" id="password" name="password"
				placeholder="Enter password"
				pattern="(?=.*\d)(?=.*[a-z])(?=.*[@#$%^&+=])(?=.*[A-Z]).{8,}"
				title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
				required /> <br /> <br /> <label for="mobileNumber">Mobile
				Number</label><br /> <input type="tel" name="mobileNo" id="mobileNo"
				placeholder="Enter mobile number" pattern="[6789][0-9]{9}"
				title="Phone number start with 6-9 and remaing 9 digit with 0-9"
				required /><br /> <br />
			<button type="submit" class="btn btn-primary">Register</button>
			<button type="reset" class="btn btn-danger">Reset</button>
		</form>
	</main>
	<script>
	function registerUser(){
		event.preventDefault();
		console.log("fun");
		let url="api/v1/users/register";
		let username=document.querySelector("#username").value;
		let password=document.querySelector("#password").value;
		let mobileNo=document.querySelector("#mobileNo").value;
		
		
		let data={username:username,password:password,mobileNo:mobileNo};
		console.log(data);
		axios.post(url,data).then(res=> {
			console.log(res);
			console.log(res.data);
			toastr.success("Registration successfull!");
			setTimeout(5000);	
			window.location.href = "login.jsp";
			
		})
		.catch(err=>{
			console.log(err.response.data);
			toastr.error(err.response.data.errorMessage);
		})
		;
		
	}
	</script>
</body>
</html>