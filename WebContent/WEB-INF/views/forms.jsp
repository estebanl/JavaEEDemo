<%@page import="co.models.FlightClass"%>
<%@page import="co.models.Gender"%>
<%@page import="co.models.PilotRank"%>
<%@page import="co.models.FlightDestinations"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Add registers</title>
</head>
<body>
	<div class=container>
		<div class="row">
			<div class="col-xs-12">
				<h1>Add flight</h1>
				<form action="AddFlight" method="post">
					<select name="flight-origin">
						<%
							for (int i = 0; i < FlightDestinations.values().length; i++) {
						%>
						<option value="<%=FlightDestinations.values()[i]%>"><%=FlightDestinations.values()[i]%></option>
						<%
							}
						%>
					</select> <select name="flight-destination">
						<%
							for (int i = 0; i < FlightDestinations.values().length; i++) {
						%>
						<option value="<%=FlightDestinations.values()[i]%>"><%=FlightDestinations.values()[i]%></option>
						<%
							}
						%>
					</select> <input type="number" name="price" placeholder="Price"> <input
						type="date" name="flight-time"> <input type="text"
						name="airplane-model" placeholder="Airplane model"> <input
						type="text" name="airplane-make" placeholder="Airplane make">
					<input type="number" name="seating-capacity"
						placeholder="Seating capacity"> <input type="submit"
						value="Save">
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<h1>Add pilot</h1>
				<form action="AddPilot" method="post">
					<input name="firstname" placeholder="First name"> 
					<input name="lastname" placeholder="lastname"> 
						<select name="pilo-rank">
						<%
							for (int i = 0; i < PilotRank.values().length; i++) {
						%><option value="<%=PilotRank.values()[i]%>"><%=PilotRank.values()[i]%></option>
						<%
							}
						%>
					</select>
					<input type="number" name="pilot-license" placeholder="Pilot license">
					<input type="number" name="flight-id" placeholder="Flight ID">
					<input type="submit" value="Save">
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<h1>Add Passenger</h1>
				<form action="AddPassenger" method="post">
					<input type="text" name="firstname" placeholder="First name">
					<input type="text" name="lastname" placeholder="Last name">
					<input type="date" name="dob" >
					<select name="gender">
						<%
							for(int i = 0; i < Gender.values().length;i++)
							{
								%>
									<option value="<%=Gender.values()[i] %>"><%=Gender.values()[i] %></option>
								<%
							}
						%>
					</select>
					<select name="flight-class">
						<%
							for(int i = 0; i < FlightClass.values().length;i++)
							{
								%>
									<option value="<%=FlightClass.values()[i] %>"><%=FlightClass.values()[i] %></option>
								<%
							}
						%>
					</select>
					<input type="submit" value="Save">
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<h1>Add passenger to flight</h1>
				<form action="AddPassengerToFlight" method="post">
				 <input type="number" name="flightId" placeholder="Flight ID">
				 <input type="number" name="passengerId" placeholder="Passenger ID">
				 <input type="submit" value="Save">
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
			  <h1>Add flight ticket to passenger</h1>
			  <form action="AddFlightTicketToPassenger" method="post">
			  	<input type="number" name="flightId" placeholder="Flight ID">
			  	<input type="number" name="passengerId" placeholder="Passenger ID">
			  	<input type="submit" value="Save">
			  </form>
			</div>
		</div>
	</div>
</body>
</html>