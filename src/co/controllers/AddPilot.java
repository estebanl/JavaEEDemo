package co.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.models.Pilot;
import co.models.PilotRank;
import co.service.PilotService;

@WebServlet("/AddPilot")
public class AddPilot extends HttpServlet {
	private static final long serialVersionUID = -6861081644435530218L;

	@EJB
	private PilotService pilotService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Pilot pilot = new Pilot();
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String pilotRank = req.getParameter("pilo-rank");
		Integer pilotLicense = Integer.parseInt(req.getParameter("pilot-license"));
		String flightId = req.getParameter("flight-id");
		
		pilot.setFirstname(firstname);
		pilot.setLastname(lastname);
		pilot.setPilokRank(PilotRank.valueOf(pilotRank));
		pilot.setPilotLicense(pilotLicense);
		
		pilotService.addPilotToFlight(pilot, flightId);
		System.out.println(pilot);
		resp.sendRedirect("ShowFlights");
	}
}
