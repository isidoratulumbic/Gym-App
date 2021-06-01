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

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public String getOpis() {
		return opis;
	}


	public void setOpis(String opis) {
		this.opis = opis;
	}


	public String getTip_treninga() {
		return tip_treninga;
	}


	public void setTip_treninga(String tip_treninga) {
		this.tip_treninga = tip_treninga;
	}


	public String getTrajanje() {
		return trajanje;
	}


	public void setTrajanje(String trajanje) {
		this.trajanje = trajanje;
	}


	public Set<ClanFitnessCentra> getClanovi() {
		return clanovi;
	}


	public void setClanovi(Set<ClanFitnessCentra> clanovi) {
		this.clanovi = clanovi;
	}


	public Set<ClanFitnessCentra> getClan_rez() {
		return clan_rez;
	}


	public void setClan_rez(Set<ClanFitnessCentra> clan_rez) {
		this.clan_rez = clan_rez;
	}


	public Set<ClanFitnessCentra> getClanovi_ocene() {
		return clanovi_ocene;
	}


	public void setClanovi_ocene(Set<ClanFitnessCentra> clanovi_ocene) {
		this.clanovi_ocene = clanovi_ocene;
	}


	public Set<Trener> getTreneri() {
		return treneri;
	}


	public void setTreneri(Set<Trener> treneri) {
		this.treneri = treneri;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Film [id=" + id + ", naziv=" + naziv + ", opis=" + opis + ", tip_treninga=" + tip_treninga + ", trajanje=" + trajanje
				+ "]";
	}
	
}
