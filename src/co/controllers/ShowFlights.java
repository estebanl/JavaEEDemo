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


import co.models.Flight;
import co.service.FlightService;

@WebServlet("/ShowFlights")
public class ShowFlights extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
	private FlightService flightService;
    public ShowFlights() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Flight> flights = flightService.getFlights();
		request.setAttribute("flights", flights);
		/*for (Flight flight : flights) {
			out.println(flight.getId()+ "<br>");
		}*/
		RequestDispatcher v = request.getRequestDispatcher("WEB-INF/views/flights.jsp");
		v.forward(request, response);
	}

}
