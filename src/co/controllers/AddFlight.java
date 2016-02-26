package co.controllers;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.models.Airplane;
import co.models.Flight;
import co.models.FlightDestinations;
import co.service.FlightService;

@WebServlet("/AddFlight")
public class AddFlight extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@EJB
	private FlightService flightService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Airplane airplane = new Airplane();
		Flight flight = new Flight();
		
		String flightDestination = req.getParameter("flight-destination");
		String flightOrigin = req.getParameter("flight-origin");
		Integer price = Integer.parseInt(req.getParameter("price"));
		String flightTime = req.getParameter("flight-time");
		String modelName = req.getParameter("airplane-model");
		String planeMake = req.getParameter("airplane-make");
		Integer seatingCapacity = Integer.parseInt(req.getParameter("seating-capacity"));
		
		airplane.setModelName(modelName);
		airplane.setPlaneMake(planeMake);
		airplane.setSeatingCapacity(seatingCapacity);
		
		flight.setFlightOrigin(FlightDestinations.valueOf(flightOrigin));
		flight.setFlightDestination(FlightDestinations.valueOf(flightDestination));
		flight.setPrice(price);
		flight.setFlightTime(new Date(System.currentTimeMillis()));
		flight.setAirplaneDetail(airplane);
		
		
		System.out.println(airplane);
		System.out.println(flight);
		System.out.println(flightTime);
		
		flightService.addFligh(flight, airplane);
		resp.sendRedirect("ShowFlights");
	}
}
