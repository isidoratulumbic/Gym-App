package wp.FitnessCentar.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
public class Trener implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, unique= true)
	private String korisnicko_ime;
	
	@Column(nullable=false, unique= true)
	private String lozinka;
		
	@Column
	private String ime;
	
	@Column
	private String prezime;
	
	@Column(nullable=false, unique= true)
	private long kontakt_elefon;
	
	@Column(nullable=false, unique= true)
	private String email;
	
	@Column
    private Date datum_rodjenja;
	
	@Column
	private boolean aktivan;
	
	@Column
	private double srednja_ocena;
	
	/*@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private FitnessCentar fitnesscentar;*/
	
	 @ManyToMany
	    @JoinTable(name = "trener_trening",
	    joinColumns = @JoinColumn(name = "trener_id", referencedColumnName = "id"),
	    inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
		private Set<Trening> treninzi = new HashSet<>();
	
	
}
