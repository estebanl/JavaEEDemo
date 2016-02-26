<%@page import="co.models.Flight"%>
<%@page import="java.util.List"%>
<%@page import="co.models.Passenger"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<title>Passengers</title>
</head>
<body>
	<div class="container">
		<div class="row">
		 	<div class="col-xs-12">
		 	<h1>Passengers</h1>
		 		<table class="table">
		 			<tr>
		 				<th>First name</th>
		 				<th>Last name</th>
		 				<th>Date</th>
		 				<th>Gender</th>
		 				<th>Flight class</th>
		 				<th>Flights</th>
		 			</tr>
		 			<%
		 			List<Passenger> passengers = (List<Passenger>) request.getAttribute("passengers");
		 			for(Passenger passenger: passengers)
		 			{
		 				%> 
		 				<tr>
		 					<td><%=passenger.getFirstname()%></td>
		 					<td><%=passenger.getLastname()%></td>
		 					<td><%=passenger.getDob()%></td>
		 					<td><%=passenger.getGender()%></td>
		 					<td><%=passenger.getFlightClass()%></td>
		 					<td>
		 					<%
		 					 	if(passenger.getFlights() != null)
		 					 	{
		 					 		for(Flight flight: passenger.getFlights())
		 					 		{
		 					 			%>
		 					 			<h4><%=flight.getId()%></h4>
		 					 			<%
		 					 		}
		 					 	}
		 					%>
		 					</td>
		 				</tr>
		 				<%
		 			}
		 			%>
		 		</table>
		 	</div>
		</div>
	</div>
</body>
</html>