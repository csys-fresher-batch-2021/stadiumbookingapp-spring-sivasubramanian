<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Check seats availability</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<br />
		<div class="container">
			<div class="row justify-content-center">
				<div class="p-3 mb-2 bg-primary text-white">
					<h2>Check Your Availability</h2>
				</div>
			</div>
		</div>
		<form method="post" onsubmit="getAvailability()">
			<br />
			<div class="form-group row">
				<label for="date" class="col-sm-2 col-form-label">Match Date</label>
				<div class="col-sm-10">
					<input type="date" class="form-control" name="date" id="matchDate"
						value="<%=request.getParameter("date")%>"
						min="<%=LocalDate.now()%>" required autofocus>
				</div>
			</div>
			<div class="form-group row">
				<label for="stadiumName" class="col-sm-2 col-form-label">Stadium
					Name</label>
				<div class="col-sm-10">
					<select name="stadiumName" id="stadiumName" class="form-control"
						class="form-select form-select-lg mb-3"
						aria-label=".form-select-lg example" required>
						<option disabled selected>select stadium</option>
						<option value="Eden Gardens,Kolkata">Eden Gardens,Kolkata</option>
						<option>M. A. Chidambaram Stadium,Chennai</option>
						<option>Wankhede Stadium,Mumbai</option>
						<option>M. Chinnaswamy Stadium,Bangalore</option>
						<option>Rajiv Gandhi International Cricket
							Stadium,Dehradun</option>
					</select>
				</div>
			</div>
			<div class="container">
				<div class="text-center">
					<button type="submit" class="btn btn-primary btn-lg">Check</button>
				</div>
			</div>
			<br />
		</form>
		<table class="table table-bordered" id="table">
			<caption>Availability</caption>

		</table>

	</main>
</body>
<script type="text/javascript">
function getAvailability(){
	event.preventDefault();
	var matchDate=document.querySelector("#matchDate").value;
	var stadiumName=document.querySelector("#stadiumName").value;
	let url="api/v1/seats/getAvailability";
	let data={matchDate:matchDate,stadiumName:stadiumName};
	axios.post(url,data).then(res=> {
		let seats=res;
		let details = "";
		console.log(res.data.length);
		for(let seat of res.data){
			details+="<thead class='thead-dark'>"+
		"<tr><th scope='col' class='bg-success'>"+"Available Seats"+"</th>"+
		"<th scope='col' class='bg-danger'>"+"Booked Seats"+"</th></tr></thead>"+
	"<tbody><tr class='table-dark'>"+
			"<td><span class='badge badge-success'>"+seat.availableSeats+"</span></td>"+
			"<td><span class='badge badge-danger'>"+seat.bookedSeats+"</span></td>"+
		"</tr></tbody>";
		console.log(seat.percentage)
		details+="<br/><div class='progress'>"+
			"<div class='progress-bar bg-success' role='progressbar'style='width: "+seat.percentage+"%' aria-valuenow='100' aria-valuemin='0' aria-valuemax='100'>"+
				"Available"+
			"</div></div>"
		}
		console.log(details);
		document.querySelector("#table").innerHTML= details;
		if(res.data.length===0){
			toastr.error("No matches available")
		}
	})
	/* .catch(err=>{
		console.log(err.response);
		toastr.error(err.response);
	})
	; */
}

</script>

</html>