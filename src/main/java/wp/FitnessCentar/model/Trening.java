package wp.FitnessCentar.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;



@Entity
public class Trening implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String naziv;
	
	@Column
	private String opis;
	
	@Column
	private String tip_treninga;
	
	@Column
	private String trajanje;
	
	@ManyToMany(mappedBy = "odradjeni_treninzi")
	private Set<ClanFitnessCentra> clanovi = new HashSet<>();
	
	@ManyToMany(mappedBy = "rezervisani_treninzi")
	private Set<ClanFitnessCentra> clan_rez = new HashSet<>();

	@ManyToMany(mappedBy = "ocene")
	private Set<ClanFitnessCentra> clanovi_ocene = new HashSet<>();
	
	@ManyToMany(mappedBy="treninzi")
	private Set<Trener>treneri=new HashSet<>();


	@Override
	public String toString() {
		return "Film [id=" + id + ", naziv=" + naziv + ", opis=" + opis + ", tip_treninga=" + tip_treninga + ", trajanje=" + trajanje
				+ "]";
	}
	
}
