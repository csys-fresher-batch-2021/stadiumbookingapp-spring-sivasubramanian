<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"
	integrity="sha512-bZS47S7sPOxkjU/4Bt0zrhEtWx0y0CRkhEp8IckzK+ltifIIE9EMIMTuT/mEzoIMewUINruDBIR/jJnbguonqQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.1/moment.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css"
	rel="stylesheet" id="bootstrap-css">

<%
String loggedInUsername = (String) session.getAttribute("LOGGED_IN_USER");
%>
<header>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<a class="navbar-brand" href="index.jsp">Stadium Booking App</a>
		<button class="navbar-toggler d-lg-none" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavId">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link" href="home.jsp">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="displayAvailability.jsp">Check Availability</a></li>
			</ul>
			<%
			if (loggedInUsername == null) {
			%>
			<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="dropdownId"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Login</a>
					<div class="dropdown-menu" aria-labelledby="dropdownId">
						<a class="dropdown-item" href="adminLogin1.jsp">Admin Login</a> <a
							class="dropdown-item" href="login.jsp">User Login</a>
					</div>
				<li class="nav-item"><a class="nav-link" href="register.jsp">Register</a></li>
				<%
				}
				if (loggedInUsername != null && !loggedInUsername.equalsIgnoreCase("admin")) {
				%>
				<li class="nav-item"><a class="nav-link" href="#">Welcome <%=loggedInUsername%></a></li>
				<li class="nav-item"><a class="nav-link" href="myBookings.jsp">My
						Bookings</a></li>
				<li class="nav-item"><a class="nav-link" href="#"
					onclick="logout()">Logout</a></li>
				<%
				}
				%>
				<%
				if (loggedInUsername != null && loggedInUsername.equalsIgnoreCase("admin")) {
				%>
				<li class="nav-item"><a class="nav-link" href="addMatch.jsp">Add
						Matches</a></li>
				<li class="nav-item"><a class="nav-link" href="viewMatches.jsp">Cancel
						Match</a></li>
				<li class="nav-item"><a class="nav-link" href="allBookings.jsp">All
						Bookings</a></li>
				<li class="nav-item"><a class="nav-link" href="#"
					onclick="logout()">logout</a></li>
			</ul>
			<%
			}
			%>
		</div>
	</nav>
</header>
<script>
function logout(){
	sessionStorage.clear();
	<%session.removeAttribute("LOGGED_IN_USER");%>
	window.location.href = "home.jsp";
	
}
</script>