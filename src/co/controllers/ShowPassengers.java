package co.controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.models.Passenger;
import co.service.PassengerService;

@WebServlet("/ShowPassengers")
public class ShowPassengers extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private PassengerService passengerService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Passenger> passengers = passengerService.getPassengers();
		req.setAttribute("passengers", passengers);
		RequestDispatcher v = req.getRequestDispatcher("WEB-INF/views/passengers.jsp");
		v.forward(req, resp);
	}

}
