package wp.FitnessCentar.model.dto;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import wp.FitnessCentar.model.FitnessCentar;

public class SalaDTO {
	private Long id;
	private String oznaka;
	private int kapacitet;
	//private String naziv;
	private String fitnessCentar;
		
	

	public SalaDTO() {
    }

	
	
	public SalaDTO(Long id, String oznaka, int kapacitet, String fitnessCentar) {
		super();
		this.id = id;
		this.oznaka = oznaka;
		this.kapacitet = kapacitet;
		this.fitnessCentar = fitnessCentar;
	}



/*public SalaDTO(Long id, String oznaka, int kapacitet,String naziv) {
		super();
		this.id = id;
		this.oznaka = oznaka;
		this.kapacitet = kapacitet;
		this.naziv=naziv;
	}*/
	

	public SalaDTO(Long id, String oznaka, int kapacitet) {
		super();
		this.id = id;
		this.oznaka = oznaka;
		this.kapacitet = kapacitet;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getOznaka() {
		return oznaka;
	}


	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}


	public int getKapacitet() {
		return kapacitet;
	}


	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}


	/*public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}*/



	public String getFitnessCentar() {
		return fitnessCentar;
	}



	public void setFitnessCentar(String fitnessCentar) {
		this.fitnessCentar = fitnessCentar;
	}


	
	
	
	
}
