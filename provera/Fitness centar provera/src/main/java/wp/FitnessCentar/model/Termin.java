package wp.FitnessCentar.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;



@Entity
public class Termin  implements Serializable{

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
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Trening trening;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Sala sala_treninga;

	@ManyToMany(mappedBy = "rezervisani_treninzi")
	private Set<Clan> clan_rez;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDan() {
		return dan;
	}

	public void setDan(String dan) {
		this.dan = dan;
	}

	public String getVreme() {
		return vreme;
	}

	public void setVreme(String vreme) {
		this.vreme = vreme;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public int getBrojRezervacija() {
		return brojRezervacija;
	}

	public void setBrojRezervacija(int brojRezervacija) {
		this.brojRezervacija = brojRezervacija;
	}

	public boolean isRezervisan() {
		return rezervisan;
	}

	public void setRezervisan(boolean rezervisan) {
		this.rezervisan = rezervisan;
	}

	public Trening getTrening() {
		return trening;
	}

	public void setTrening(Trening trening) {
		this.trening = trening;
	}

	public Sala getSala_treninga() {
		return sala_treninga;
	}

	public void setSala_treninga(Sala sala_treninga) {
		this.sala_treninga = sala_treninga;
	}

	public Set<Clan> getClan_rez() {
		return clan_rez;
	}

	public void setClan_rez(Set<Clan> clan_rez) {
		this.clan_rez = clan_rez;
	}


	


	
	
	


	

}