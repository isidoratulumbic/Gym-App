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

	public Set<FitnessCentar> getTreninzi() {
		return treninzi;
	}

	public void setTreninzi(Set<FitnessCentar> treninzi) {
		this.treninzi = treninzi;
	}

	public Set<Sala> getSale() {
		return sale;
	}

	public void setSale(Set<Sala> sale) {
		this.sale = sale;
	}
	
	

}
