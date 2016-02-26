package co.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import co.models.Airplane;
import co.models.Flight;
import co.models.Passenger;
import co.models.Pilot;

@Stateless
@LocalBean
public class FlightService {

	public FlightService() {
	}
	
	@PersistenceContext(unitName = "web4JPA")
	private EntityManager entityManager;
	
	public void addFligh(Flight flight, Airplane airplane)
	{
		entityManager.persist(flight);
		//entityManager.persist(airplane);
	}
	
	public void addPilotToFlight(String pilotId, String flightId)
	{
		TypedQuery<Flight> flightQuery = entityManager.createNamedQuery("Flight.findById",Flight.class);
		flightQuery.setParameter("id", Integer.parseInt(flightId));
		Flight flight = flightQuery.getSingleResult();
		TypedQuery<Pilot> pilotQuery = entityManager.createNamedQuery("Pilot.findById", Pilot.class);
		pilotQuery.setParameter("id", Integer.parseInt(pilotId));
		Pilot pilot = pilotQuery.getSingleResult();
		
		List<Pilot> pilots = flight.getPilots();
		pilots.add(pilot);
		flight.setPilots(pilots);
		pilot.setFlightForPilot(flight);
	}
	
	public List<Flight> getFlights()
	{
		List<Flight> flights = new ArrayList<>();
		TypedQuery<Flight> query = entityManager.createQuery("select f from Flight f",Flight.class);
		flights = query.getResultList();
		return flights;
	}
	
	public void addPassengerToFlight(String passengerId, String flightId)
	{
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Passenger> criteriaQueryPassenger = builder.createQuery(Passenger.class);
		Root<Passenger> passengerRoot = criteriaQueryPassenger.from(Passenger.class);
		criteriaQueryPassenger.select(passengerRoot).where(builder.equal(passengerRoot.get("id").as(Integer.class), passengerId));
		TypedQuery<Passenger> passengerQuery = entityManager.createQuery(criteriaQueryPassenger);
		Passenger passenger = passengerQuery.getSingleResult();
		
		builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Flight> criteriaQueryFlight = builder.createQuery(Flight.class);
		Root<Flight> flightRoot = criteriaQueryFlight.from(Flight.class);
		criteriaQueryFlight.select(flightRoot).where(builder.equal(flightRoot.get("id").as(Integer.class), flightId));
		TypedQuery<Flight> flightQuery = entityManager.createQuery(criteriaQueryFlight);
		Flight flight = flightQuery.getSingleResult();
		
		List<Passenger> passengers = flight.getPassengers();
		passengers.add(passenger);
		passenger.getFlights().add(flight);
	}
}
