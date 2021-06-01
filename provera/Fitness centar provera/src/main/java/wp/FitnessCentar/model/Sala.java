package wp.FitnessCentar.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Sala implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private int kapacitet;
	
	@Column 
	private String oznaka;

	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private FitnessCentar fitness_centar;

	@OneToMany(mappedBy="sala_treninga", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Termin> termini;
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public int getKapacitet() {
		return kapacitet;
	}



	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}



	public String getOznaka() {
		return oznaka;
	}



	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}



	public FitnessCentar getFitness_centar() {
		return fitness_centar;
	}



	public void setFitness_centar(FitnessCentar fitness_centar) {
		this.fitness_centar = fitness_centar;
	}



	public Set<Termin> getTermini() {
		return termini;
	}



	public void setTermini(Set<Termin> termini) {
		this.termini = termini;
	}



	@Override
	public String toString() {
		return "Sala [id=" + id + ", kapacitet=" + kapacitet + ", oznaka=" + oznaka + "]";
	}
	
	

}
	
