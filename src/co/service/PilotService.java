package co.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.models.Flight;
import co.models.Pilot;

@Stateless
@LocalBean
public class PilotService {

	public PilotService() {
	}
	
	@PersistenceContext(unitName = "web4JPA")
	private EntityManager entityManager;
	
	public void addPilot(Pilot pilot)
	{
		entityManager.persist(pilot);
	}
	
	public void addPilotToFlight(Pilot pilot, String flightId)
	{
		entityManager.persist(pilot);
		TypedQuery<Flight> flightQuery = entityManager.createNamedQuery("Flight.findById",Flight.class);
		flightQuery.setParameter("id", Integer.parseInt(flightId));
		Flight flight = flightQuery.getSingleResult();
		
		List<Pilot> pilots = flight.getPilots();
		pilots.add(pilot);
		flight.setPilots(pilots);
		pilot.setFlightForPilot(flight);
	}
}
