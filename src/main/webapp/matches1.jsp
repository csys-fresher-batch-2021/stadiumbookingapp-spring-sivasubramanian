<%@page import="org.eclipse.jdt.internal.compiler.ast.ForeachStatement"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="in.siva.model.MatchDetail"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Available Matches</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Available Matches</h3>
		<div class="container">
			<div class="row">
				<div class="col-4 p-3 mb-2 bg-success text-white">Available</div>
				<div class="col-4 p-3 mb-2 bg-warning text-white">Almost
					Filled</div>
				<div class="col-4 p-3 mb-2 bg-danger text-white">Filling fast</div>
			</div>
		</div>
		<div class="container">
			<div class="row" id="match_table"></div>
		</div>
		<script type="text/javascript">
function getAllMatches(){
	let url = "api/v1/match/ViewMatches";
	fetch(url).then(response=> response.json()).then(res=>{
		let matches = res;
		let details = "";
		let i=0;
		for(let match of matches){
			console.log(match);
			console.log("id"+match.id);
			var percentage=(match.availableSeats*100)/match.totalSeats;
			if(percentage > 50){
			details +="<div class='col-lg-6 mb-4' >"+
			"<div class='card' style='width: 20rem'>"+
			"<img class='card-img-top' src='images/"+match.image+"' alt='Card image cap'>"+
			"<div class='card-block'>"+
				"<h4 class='card-title'><p  class='text-success'>"+ match.teamOne+"-"+match.teamTwo+"</p></h4>"+
				"<p class='card-text'><p  class='text-success'>"+match.matchDate+"<br />"+match.matchTime+"<br />"+match.stadiumName+
				"</p></p>"+
				"<a href='booking.jsp?date="+match.matchDate+"&id="+match.id+"' class='btn btn-success'>"+ "Book Now" +"</a>"+
			"</div></div></div>"
			}
		
			else if(percentage < 50 && percentage > 30 ){
				details +="<div class='col-lg-6 mb-4' >"+
				"<div class='card' style='width: 20rem'>"+
				"<img class='card-img-top' src='images/"+match.image+"' alt='Card image cap'>"+
				"<div class='card-block'>"+
					"<h4 class='card-title'><p  class='text-warning'>"+ match.teamOne+"-"+match.teamTwo+"</p></h4>"+
					"<p class='card-text'><p  class='text-warning'>"+match.matchDate+"<br />"+match.matchTime+"<br />"+match.stadiumName+
					"</p></p>"+
					"<a href='booking.jsp?date="+match.matchDate+"' class='btn btn-warning'>"+ "Book Now" +"</a>"+
				"</div></div></div>"
				}
		}
		document.querySelector("#match_table").innerHTML= details;
	})
	
}
getAllMatches();

</script>
	</main>
</body>
</html>