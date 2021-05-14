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


	
	@Override
	public String toString() {
		return "Sala [id=" + id + ", kapacitet=" + kapacitet + ", oznaka=" + oznaka + "]";
	}
	
	

}
