package wp.FitnessCentar.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Administrator implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, unique= true)
	private String korisnicko_ime;
	
	@Column(nullable=false, unique= true)
	private String lozinka;
		
	@Column
	private String ime;
	
	@Column
	private String prezime;
	
	@Column(nullable=false, unique= true)
	private long kontakt_elefon;
	
	@Column(nullable=false, unique= true)
	private String email;
	
	@Column
    private Date datum_rodjenja;
	
	@Column
	private boolean aktivan;

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

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
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

	public long getKontakt_elefon() {
		return kontakt_elefon;
	}

	public void setKontakt_elefon(long kontakt_elefon) {
		this.kontakt_elefon = kontakt_elefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDatum_rodjenja() {
		return datum_rodjenja;
	}

	public void setDatum_rodjenja(Date datum_rodjenja) {
		this.datum_rodjenja = datum_rodjenja;
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}
	
	
}