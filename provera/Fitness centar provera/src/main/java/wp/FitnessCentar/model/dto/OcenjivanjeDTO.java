package wp.FitnessCentar.model.dto;


public class OcenjivanjeDTO {
	private String korisnickoIme;
	private String lozinka;
	private String id;
	private Double ocena;
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getOcena() {
		return ocena;
	}
	public void setOcena(Double ocena) {
		this.ocena = ocena;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	
	
}
