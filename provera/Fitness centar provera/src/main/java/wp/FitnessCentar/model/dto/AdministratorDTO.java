package wp.FitnessCentar.model.dto;

public class AdministratorDTO {

    private Long id;
    private String korisnicko_ime;
    private String ime;
    private String prezime;
    private String kontakt_telefon;
    private String datum_rodjenja;
    private String uloga;
    
    public AdministratorDTO() {
    }
    
	public AdministratorDTO(Long id, String korisnicko_ime, String ime, String prezime,
			String kontakt_telefon, String datum_rodjenja, String uloga) {
		super();
		this.id = id;
		this.korisnicko_ime = korisnicko_ime;
		this.ime = ime;
		this.prezime = prezime;
		this.kontakt_telefon = kontakt_telefon;
		this.datum_rodjenja = datum_rodjenja;
		this.uloga = uloga;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKorisnicko_ime() {
		return korisnicko_ime;
	}

	public void setKorisnicko_ime(String korisnicko_ime) {
		this.korisnicko_ime = korisnicko_ime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getKontakt_telefon() {
		return kontakt_telefon;
	}

	public void setKontakt_telefon(String kontakt_telefon) {
		this.kontakt_telefon = kontakt_telefon;
	}

	public String getDatum_rodjenja() {
		return datum_rodjenja;
	}

	public void setDatum_rodjenja(String datum_rodjenja) {
		this.datum_rodjenja = datum_rodjenja;
	}

	public String getUloga() {
		return uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
	}
    
    


}