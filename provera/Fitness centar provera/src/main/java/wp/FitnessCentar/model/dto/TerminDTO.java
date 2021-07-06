package wp.FitnessCentar.model.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import wp.FitnessCentar.model.Termin;
import wp.FitnessCentar.model.Trening;

public class TerminDTO {
	
	private Long id;
	private String naziv;
    private String opis;
	private String tipTreninga;
	private String trajanje;
	private String dan;
	private String vreme;
	private int cena;
	private int brojRezervacija;


	

	public TerminDTO(Long id, String naziv, String opis, String tipTreninga, String trajanje, String dan, String vreme,
			int cena, int brojRezervacija) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.tipTreninga = tipTreninga;
		this.trajanje = trajanje;
		this.dan = dan;
		this.vreme = vreme;
		this.cena = cena;
		this.brojRezervacija = brojRezervacija;
	}







	public TerminDTO(String naziv, String opis, String tipTreninga, String trajanje, String dan, String vreme,
			int cena, int brojRezervacija) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		this.tipTreninga = tipTreninga;
		this.trajanje = trajanje;
		this.dan = dan;
		this.vreme = vreme;
		this.cena = cena;
		this.brojRezervacija = brojRezervacija;
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



	public String getTipTreninga() {
		return tipTreninga;
	}



	public void setTipTreninga(String tipTreninga) {
		this.tipTreninga = tipTreninga;
	}



	public String getTrajanje() {
		return trajanje;
	}



	public void setTrajanje(String trajanje) {
		this.trajanje = trajanje;
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