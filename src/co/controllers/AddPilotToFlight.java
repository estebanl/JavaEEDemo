package co.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.service.FlightService;

@WebServlet("/AddPilotToFlight")
public class AddPilotToFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private FlightService flightService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pilotId = req.getParameter("pilotId");
		String flightId = req.getParameter("flightId");
		flightService.addPilotToFlight(pilotId, flightId);
		System.out.println(pilotId + flightId);
	}

}
