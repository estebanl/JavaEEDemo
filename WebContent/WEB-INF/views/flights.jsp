<%@page import="co.models.Passenger"%>
<%@page import="co.models.Pilot"%>
<%@page import="co.models.Flight"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<title>Flights</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>Flights</h1>
			<table class="table">
				<tr>
					<th>From</th>
					<th>To</th>
					<th>Time</th>
					<th>Price</th>
					<th>Airplane</th>
					<th>Seating</th>
					<th>Number of pilots</th>
					<th>Pilot names</th>
					<th>Passengers</th>
				</tr>
				<%
					List<Flight> flights = (List<Flight>) request.getAttribute("flights");
					for (Flight flight : flights) {
				%>
				<tr>
					<td><%=flight.getFlightOrigin()%></td>
					<td><%=flight.getFlightDestination()%></td>
					<td><%=flight.getFlightTime()%></td>
					<td><%=flight.getPrice()%></td>
					<td><%=flight.getAirplaneDetail().getModelName()%></td>
					<td><%=flight.getAirplaneDetail().getSeatingCapacity()%></td>
					<td><%=flight.getPilots().size()%></td>
					<td>
						<%
							if (flight.getPilots() != null) {
									for (Pilot pilot : flight.getPilots()) {
										%><%=pilot.getFirstname() %><br><%
									}
								}
						%>
					</td>
					<td>
						<%
						 if(flight.getPassengers() != null) {
							 for(Passenger passenger: flight.getPassengers())
							 {
								 %><%=passenger.getFirstname()%><%
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
</body>
</html>