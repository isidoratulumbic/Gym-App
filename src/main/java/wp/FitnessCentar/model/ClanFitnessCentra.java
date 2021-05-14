package wp.FitnessCentar.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
public class ClanFitnessCentra implements Serializable{
	
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
	
	 @ManyToMany
	    @JoinTable(name = "clan_trening",
	    joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
	    inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
		private Set<Trening> odradjeni_treninzi = new HashSet<>();
	 
	 @ManyToMany
	    @JoinTable(name = "clan_rez_trening",
	    joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
	    inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
		private Set<Trening> rezervisani_treninzi = new HashSet<>();
	 
	 @ManyToMany
	    @JoinTable(name = "clan_ocenjen_film",
	    joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
	    inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
		private Set<Trening> ocene = new HashSet<>(); // tipa je trening jer klasa Trening sadrzi polje ocena
	
	
}

