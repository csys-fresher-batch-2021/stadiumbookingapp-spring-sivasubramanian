<%@page import="in.siva.model.Matches"%>
<%@page import="java.time.LocalDate"%>
<%@page import="in.siva.model.MatchDetail"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Booking</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="booking-form">
			<div class="form-header">
				<h1>Book your Seats</h1>
			</div>
		</div>
		<%
		%>

		<%
		
		String errorMessage = request.getParameter("errorMessage");
		String infoMessage = request.getParameter("infoMessage");
		if (errorMessage != null) {
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
		if (infoMessage != null) {
			out.println("<font color='green'>" + infoMessage + "</font>");
		}
		/* List<Matches> matchDetail=(List<Matches>)session.getAttribute("MATCH_DETAIL");
		int matchId=0;
		for(Matches detail:matchDetail){
			 matchId=detail.getId();
		} */
		//String matchId = request.getParameter("id");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate matchDate=LocalDate.parse(request.getParameter("date"),formatter);
		%>
		<form method="post" onsubmit="bookSeats()">
			<label for="matchDate">Match Date</label><br /> <input type="date"
				name="matchDate" value="<%=matchDate.toString()%>" readonly><br />
			<br /> <label for="type">Seat Type</label><br /> <select id="type"
				name="type" required onchange="calculateTotal()" autofocus>
				<option disabled selected>--select seat type--</option>
				<option value="upper">Upper</option>
				<option value="lower">Lower</option>
			</select><br /> <br /> <label for="noOfTickets">Number of tickets</label><br />
			<input type="number" min="1" placeholder="Enter Number of tickets"
				id="no" name="noOfTickets" onchange="calculateTotal()" required><br />
			<br /> <label for="total">Amount(Rs)</label><br /> <input
				type="number" id="total" name="amount" value=0 readonly><br />
			<br />
			<button type="submit" class="btn btn-primary">Book</button>

		</form>
	</main>
	<script type="text/javascript">
		function calculateTotal() {
			<%List<Matches> matchDetailList=(List<Matches>)session.getAttribute("MATCH_DETAIL");
			for(Matches detail:matchDetailList){%>
				 var upperSeatPrice=<%=detail.getUpperSeatPrice()%>
				 var lowerSeatPrice=<%=detail.getLowerSeatPrice()%>
				 var matchId=<%=detail.getId()%><%}%>;
			/* const queryString = window.location.search;
			const urlParams = new URLSearchParams(queryString);
			const upperPrice = urlParams.get('up');
			const lowerPrice = urlParams.get('lp'); */
			var type = document.querySelector("#type").value;
			var numberOfSeats = document.querySelector("#no").value;
			if (type == 'upper' && numberOfSeats > 0) {
				var price = upperSeatPrice * numberOfSeats;
			}
			else if (type == 'lower' && numberOfSeats > 0) {
				var price = lowerSeatPrice * numberOfSeats;
			}
			else{
				var price=0;
			}
			document.querySelector("#total").value = price;
		}
		
		function bookSeats(){
			event.preventDefault();
			<%
			List<Matches> match=(List<Matches>)session.getAttribute("MATCH_DETAIL");
			for(Matches detail:match){%>
				 var upperSeatPrice=<%=detail.getUpperSeatPrice()%>
				 var lowerSeatPrice=<%=detail.getLowerSeatPrice()%><%}%>;
			var userId=<%=session.getAttribute("LOGGED_IN_USER_ID")%>;
			console.log("userId-"+userId)
			const queryString = window.location.search;
			const urlParams = new URLSearchParams(queryString);
			const matchId = urlParams.get('id');
			var seatType = document.querySelector("#type").value;
			var tickets = document.querySelector("#no").value;
			console.log("num="+tickets);
			if (seatType == 'upper' && tickets > 0) {
				var price = upperSeatPrice * tickets;
			}
			else if (seatType == 'lower' && tickets > 0) {
				var price = lowerSeatPrice * tickets;
			}
			else{
				var price=0;
			}
			console.log("price"+price)
			let url="api/v1/booking/bookSeat"
			let data={userId:userId,matchId:matchId,seatType:seatType,tickets:tickets,totalAmount:price};
			axios.post(url,data).then(res=> {
				console.log(res);
				console.log(res.data);
				toastr.success("Booking successfull!");
			})
			.catch(err=>{
				console.log(err.response.data);
				toastr.error(err.response.data);
			})
			;
		
		}
	</script>

</body>
</html>