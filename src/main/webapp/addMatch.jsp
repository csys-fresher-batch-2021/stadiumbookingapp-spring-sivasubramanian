<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add matches</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Add Matches Details</h3>
		<form action="/addMatches" method="post">

			<br /> <select class="selectpicker" name="stadiumName" autofocus>
				<option disabled selected>-------------------- select
					stadium --------------------</option>
				<option>Eden Gardens,Kolkata</option>
				<option>M. A. Chidambaram Stadium,Chennai</option>
				<option>Wankhede Stadium,Mumbai</option>
				<option>M. Chinnaswamy Stadium,Bangalore</option>
				<option>Rajiv Gandhi International Cricket Stadium,Dehradun</option>
			</select> <br /> <br /> <label for="matchDate">Set Date and time</label> <br />
			<input type="date" id="matchDate" name="matchDate"
				min="<%=LocalDate.now()%>" required> <input type="time"
				id="matchtime" name="matchTime" required> <br /> <br /> <label
				for="team1">Team 1</label> <br /> <select class="selectpicker"
				data-live-search="true" name="team1" required>
				<option disabled selected>----Choose team1----</option>
				<option>CSK</option>
				<option>MI</option>
				<option>SRH</option>
				<option>KKR</option>
				<option>RCB</option>
				<option>RR</option>
				<option>PK</option>
				<option>DC</option>
			</select><br /> <br /> <label for="team2">Team 2</label> <br /> <select
				class="selectpicker" data-live-search="true" name="team2" required>
				<option disabled selected>----Choose team2----</option>
				<option>CSK</option>
				<option>MI</option>
				<option>SRH</option>
				<option>KKR</option>
				<option>RCB</option>
				<option>RR</option>
				<option>PK</option>
				<option>DC</option>
			</select> <br /> <br /> <input type="number" min="100" name="totalSeats"
				placeholder="Enter total seats" id="totalSeats"
				onchange="setAvailableSeats()" required> <br /> <br /> <input
				type="number" name="availableSeats" id="availableSeats"
				placeholder="Enter available seats" required readonly> <br />
			<br /> <input type="number" name="upperSeatPrice" min="800"
				placeholder="Enter upper seat price" required> <br /> <br />
			<input type="number" name="lowerSeatPrice"
				placeholder="Enter lower seat price" required> <br /> <br />
			<input type="text" min="1000" name="image"
				placeholder="Enter image url" value="IPLlogo.jpg" readonly
				title="Enter team1-team2.jpg eg.csk-mi.jpg" required> <br />
			<br />
			<button type="submit" class="btn btn-primary">Submit</button>
			&nbsp;
			<button type="reset" class="btn btn-danger">Reset</button>
		</form>
	</main>
	<script type="text/javascript">
		function setAvailableSeats() {
			var total = document.querySelector("#totalSeats").value
			document.querySelector("#availableSeats").value = total;
		}
		var infoMessage ="<%=request.getParameter("infoMessage")%>";
		var errorMessage ="<%=request.getParameter("errorMessage")%>";
		console.log("info-"+infoMessage);
		console.log("error-"+errorMessage);
		if (errorMessage !== 'null') {
			toastr.error(errorMessage);
		}
		if (infoMessage !== 'null') {
			toastr.success(infoMessage);
		}
		
	</script>
</body>
</html>