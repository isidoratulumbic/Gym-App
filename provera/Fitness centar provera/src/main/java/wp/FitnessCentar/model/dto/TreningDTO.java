package wp.FitnessCentar.model.dto;

public class TreningDTO {
	
	private Long id;
	private String naziv;
	private String opis;
	private String tipTreninga;
	private String trajanje;
	private Double srednjaOcjena;
	
	public TreningDTO() {
		
	}

	public TreningDTO(Long id, String naziv, String opis, String tipTreninga, String trajanje,Double srednjaOcjena) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.tipTreninga = tipTreninga;
		this.trajanje = trajanje;
		this.srednjaOcjena = srednjaOcjena;
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
	
	public Double getSrednjaOcjena() {
		return srednjaOcjena;
	}
	public void setSrednjaOcjena(Double srednjaOcjena) {
		this.srednjaOcjena = srednjaOcjena;
	}


}
