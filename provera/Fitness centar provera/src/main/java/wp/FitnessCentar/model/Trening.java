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
	private Set<Clan> clanovi;
	
	@ManyToMany(mappedBy = "rezervisani_treninzi")
	private Set<Clan> clan_rez;

	@OneToMany(mappedBy= "trening", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Ocena> ocene;
	
	@OneToMany(mappedBy= "trening", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Termin> termini;







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







	public Set<Clan> getClanovi() {
		return clanovi;
	}







	public void setClanovi(Set<Clan> clanovi) {
		this.clanovi = clanovi;
	}







	public Set<Clan> getClan_rez() {
		return clan_rez;
	}







	public void setClan_rez(Set<Clan> clan_rez) {
		this.clan_rez = clan_rez;
	}







	public Set<Ocena> getOcene() {
		return ocene;
	}







	public void setOcene(Set<Ocena> ocene) {
		this.ocene = ocene;
	}







	public Set<Termin> getTermini() {
		return termini;
	}







	public void setTermini(Set<Termin> termini) {
		this.termini = termini;
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
