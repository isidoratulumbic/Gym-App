package wp.FitnessCentar.model.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import wp.FitnessCentar.model.Termin;

public class TreningDTO {
	
	private Long id;
	private String naziv;
	private String opis;
	private String tipTreninga;
	private String trajanje;
	private Double srednjaOcjena;
	private String dan;
	private String vreme;
	private int cena;
	private int brojRezervacija;
	private String salaOznaka;
	private String FitnessCentar;
	private Long clanID;
	private Double srednjaOcena;
	
	public TreningDTO() {
		
	}


	

	public TreningDTO(Long id, String naziv, String opis, String tipTreninga, String trajanje, Double srednjaOcena,
			String dan, String vreme, int cena, int brojRezervacija, String salaOznaka, String fitnessCentar,
			Long clanID) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.tipTreninga = tipTreninga;
		this.trajanje = trajanje;
		this.srednjaOcena = srednjaOcena;
		this.dan = dan;
		this.vreme = vreme;
		this.cena = cena;
		this.brojRezervacija = brojRezervacija;
		this.salaOznaka = salaOznaka;
		FitnessCentar = fitnessCentar;
		this.clanID = clanID;
		this.srednjaOcena = srednjaOcena;
	}




	public TreningDTO(Long id,String naziv, String opis, String tipTreninga) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.tipTreninga = tipTreninga;
		
	}




	public TreningDTO(Long id, String naziv, String opis, String tipTreninga, String trajanje, Double srednjaOcjena) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.tipTreninga = tipTreninga;
		this.trajanje = trajanje;
		this.srednjaOcena = srednjaOcena;
		
	}



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




	public String getSalaOznaka() {
		return salaOznaka;
	}




	public void setSalaOznaka(String salaOznaka) {
		this.salaOznaka = salaOznaka;
	}




	




	public String getFitnessCentar() {
		return FitnessCentar;
	}




	public void setFitnessCentar(String fitnessCentar) {
		FitnessCentar = fitnessCentar;
	}




	public Long getClanID() {
		return clanID;
	}




	public void setClanID(Long clanID) {
		this.clanID = clanID;
	}




	public Double getSrednjaOcena() {
		return srednjaOcena;
	}




	public void setSrednjaOcena(Double srednjaOcena) {
		this.srednjaOcena = srednjaOcena;
	}

	
	

	
}
