package wp.FitnessCentar.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Treninzi  implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	@Column
	private String dan;
	@Column
	private String vreme;
	@Column
	private int cena;
	@Column
	private int brojRezervacija;
	@Column
	private boolean rezervisan;
	
	@ManyToOne
	@JoinColumn
	private Trening trening;
	
	@ManyToMany(mappedBy = "raspored")
	private Set<FitnessCentar> treninzi = new HashSet<>();
	
	@ManyToMany(mappedBy = "treninzi")
	private Set<Sala> sale = new HashSet<>();

}
