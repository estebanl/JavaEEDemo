package co.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.service.PassengerService;

@WebServlet("/AddFlightTicketToPassenger")
public class AddFlightTicketToPassenger extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@EJB
	private PassengerService passengerService;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String flightId = req.getParameter("flightId");
		String passengerId = req.getParameter("passengerId");
		passengerService.addFlightTicketToPassenger(flightId,passengerId);
		resp.sendRedirect("ShowPassengers");
		
	}

}
