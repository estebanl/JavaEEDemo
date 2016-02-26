package co.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@NamedQuery(name = "Pilot.findById", query = "SELECT p FROM Pilot p WHERE p.id = :id")
@Entity
public class Pilot {
	
	public Pilot() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String firstname;
	
	private String lastname;
	
	private Integer pilotLicense;
	
	@Enumerated(EnumType.STRING)
	private PilotRank pilokRank;
	
	@ManyToOne
	@JoinColumn(name = "flight_fk")
	private Flight flightForPilot;

	public Integer getId() {
		return id;
	}

	public Flight getFlightForPilot() {
		return flightForPilot;
	}

	public void setFlightForPilot(Flight flightForPilot) {
		this.flightForPilot = flightForPilot;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getPilotLicense() {
		return pilotLicense;
	}

	public void setPilotLicense(Integer pilotLicense) {
		this.pilotLicense = pilotLicense;
	}

	public PilotRank getPilokRank() {
		return pilokRank;
	}

	public void setPilokRank(PilotRank pilokRank) {
		this.pilokRank = pilokRank;
	}

	@Override
	public String toString() {
		return "Pilot [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", pilotLicense="
				+ pilotLicense + ", pilokRank=" + pilokRank + ", flightForPilot=" + flightForPilot + "]";
	}
}
