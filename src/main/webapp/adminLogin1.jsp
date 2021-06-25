<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Admin Login</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Admin Login</h3>
		<%
		String errorMessage = request.getParameter("errorMessage");
		if (errorMessage != null) {
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
		%>
		<p>
			Username : admin<br /> password : admin@123
		</p>
		<form action="/adminLogin" method="post">
			<br> <input type="text" name="username" id="username"
				autocomplete="off" required placeholder="Enter User Name" autofocus><br />
			<br> <input type="password" name="password" id="password"
				autocomplete="off" required placeholder="Enter Password"><br />
			<br>
			<button class="btn btn-secondary" type="submit">Submit</button>
			<button class="btn btn-danger" type="reset">Reset</button>
			<br />
		</form>
	</main>
</body>
</html>