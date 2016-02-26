package co.controllers;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.models.FlightClass;
import co.models.Gender;
import co.models.Passenger;
import co.service.PassengerService;

@WebServlet("/AddPassenger")
public class AddPassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PassengerService passengerService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Passenger passenger = new Passenger();
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String gender = req.getParameter("gender");
		String flighClass = req.getParameter("flight-class");
		
		passenger.setFirstname(firstname);
		passenger.setLastname(lastname);
		passenger.setDob(new Date(System.currentTimeMillis()));
		passenger.setGender(Gender.valueOf(gender));
		passenger.setFlightClass(FlightClass.valueOf(flighClass));
		
		System.out.println(passenger);
		passengerService.addPassenger(passenger);
		resp.sendRedirect("ShowPassengers");
	}
}
