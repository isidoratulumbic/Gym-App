package wp.FitnessCentar.model.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import wp.FitnessCentar.model.Termin;
import wp.FitnessCentar.model.Trening;

public class TerminDTO {
	
	private Long id;
	private String dan;
	private String vreme;
	private int cena;
	private int brojRezervacija;
	
	public TerminDTO() {
		
	}

	public TerminDTO(Long id, String dan, String vreme, int cena, int brojRezervacija
			) {
		super();
		this.id = id;
		this.dan = dan;
		this.vreme = vreme;
		this.cena = cena;
		this.brojRezervacija = brojRezervacija;
	}

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




	
}