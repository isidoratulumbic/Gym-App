package wp.FitnessCentar.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
public class Trener implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, unique= true)
	private String korisnickoIme;
	
	@Column(nullable=false, unique= true)
	private String lozinka;
		
	@Column
	private String ime;
	
	@Column
	private String prezime;
	
	@Column(nullable=false, unique= true)
	private String kontakt_telefon;
	
	@Column(nullable=false, unique= true)
	private String email;
	
	@Column
    private String datum_rodjenja;
	
	@Column
	protected String uloga;
	
	@Column
	private boolean aktivan;
	
	/*@Column
	private double srednja_ocena;*/
	
	
	
	 @ManyToMany
	    @JoinTable(name = "trener_trening",
	    joinColumns = @JoinColumn(name = "trener_id", referencedColumnName = "id"),
	    inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
		private Set<Trening> treninzi;

		@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
		private FitnessCentar fitness_centar;

		public Trener() {
	    }
		
		public Trener(Long id,String korisnickoIme, String lozinka, String ime, String prezime, String kontakt_telefon,
				String email, String datum_rodjenja, String uloga) {
			super();
			this.id=id;
			this.korisnickoIme = korisnickoIme;
			this.lozinka = lozinka;
			this.ime = ime;
			this.prezime = prezime;
			this.kontakt_telefon = kontakt_telefon;
			this.email = email;
			this.datum_rodjenja = datum_rodjenja;
			this.uloga = uloga;
		}
		

		public Trener(String korisnickoIme, String lozinka, String ime, String prezime, String kontakt_telefon,
				String email, String datum_rodjenja, String uloga) {
			super();
			this.korisnickoIme = korisnickoIme;
			this.lozinka = lozinka;
			this.ime = ime;
			this.prezime = prezime;
			this.kontakt_telefon = kontakt_telefon;
			this.email = email;
			this.datum_rodjenja = datum_rodjenja;
			this.uloga = uloga;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getKorisnickoIme() {
			return korisnickoIme;
		}

		public void setKorisnickoIme(String korisnickoIme) {
			this.korisnickoIme = korisnickoIme;
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

		public String getKontakt_telefon() {
			return kontakt_telefon;
		}

		public void setKontakt_telefon(String kontakt_telefon) {
			this.kontakt_telefon = kontakt_telefon;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
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

		public boolean isAktivan() {
			return aktivan;
		}

		public void setAktivan(boolean aktivan) {
			this.aktivan = aktivan;
		}

		/*public double getSrednja_ocena() {
			return srednja_ocena;
		}

		public void setSrednja_ocena(double srednja_ocena) {
			this.srednja_ocena = srednja_ocena;
		}*/

		public Set<Trening> getTreninzi() {
			return treninzi;
		}

		public void setTreninzi(Set<Trening> treninzi) {
			this.treninzi = treninzi;
		}

		public FitnessCentar getFitness_centar() {
			return fitness_centar;
		}

		public void setFitness_centar(FitnessCentar fitness_centar) {
			this.fitness_centar = fitness_centar;
		}

		
		
		
	
	 
	 
	
	
}
