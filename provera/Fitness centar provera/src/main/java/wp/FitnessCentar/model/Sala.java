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
	
	@ManyToMany
    @JoinTable(name = "sala_treninga",
    joinColumns = @JoinColumn(name = "sala_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "treninzi_id", referencedColumnName = "id"))
	private Set<Trening> treninzi = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private FitnessCentar fitness_centar;

	
	
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



	public Set<Trening> getTreninzi() {
		return treninzi;
	}



	public void setTreninzi(Set<Trening> treninzi) {
		this.treninzi = treninzi;
	}



	public FitnessCentar getFitness_centar() {
		return fitness_centar;
	}



	public void setFitness_centar(FitnessCentar fitness_centar) {
		this.fitness_centar = fitness_centar;
	}



	@Override
	public String toString() {
		return "Sala [id=" + id + ", kapacitet=" + kapacitet + ", oznaka=" + oznaka + "]";
	}
	
	

}
