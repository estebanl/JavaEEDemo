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

import co.models.Flight;
import co.models.Passenger;

@Stateless
@LocalBean
public class PassengerService {

	public PassengerService() {
	}
	
	@PersistenceContext(unitName= "web4JPA")
	private EntityManager entityManager;
	
	public void addPassenger(Passenger p)
	{
		entityManager.persist(p);
	}
	
	public List<Passenger> getPassengers()
	{
		List<Passenger> passengers = new ArrayList<>();
		TypedQuery<Passenger> query = entityManager.createQuery("select p from Passenger p", Passenger.class);
		passengers = query.getResultList();
		return passengers;
	}

	public void addFlightTicketToPassenger(String flightId, String passengerId) {
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
		
		List<Flight> flights = passenger.getFlights();
		flights.add(flight);
		passenger.setFlights(flights);
		flight.getPassengers().add(passenger);
	}
}
