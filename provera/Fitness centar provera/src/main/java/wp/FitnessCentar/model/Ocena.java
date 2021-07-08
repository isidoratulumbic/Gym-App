package wp.FitnessCentar.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity 
public class Ocena implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private  Clan clan;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private  Trening trening;
	
	@Column
	private Double ocena;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Clan getClan() {
		return clan;
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}

	public Trening getTrening() {
		return trening;
	}

	public void setTrening(Trening trening) {
		this.trening = trening;
	}

	public Double getOcena() {
		return ocena;
	}

	public void setOcena(Double ocena) {
		this.ocena = ocena;
	}
	
	
	
	
	
}
