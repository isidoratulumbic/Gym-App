package wp.FitnessCentar.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
public class FitnessCentar implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column 
	private String naziv;
	
	@Column 
	private String adresa;
	
	@Column 
	private long broj_telefona_centrale;
	
	@Column
	private String email;
	
	@OneToMany(mappedBy="fitness_centar",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Trener> treneri ;
	
	@OneToMany(mappedBy = "fitness_centar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Sala> sale;

	

	private Administrator administrator;

	public FitnessCentar() {
	}
	
	
	
	
	public FitnessCentar( String naziv, String adresa, long broj_telefona_centrale, String email) {
		super();
		
		this.naziv = naziv;
		this.adresa = adresa;
		this.broj_telefona_centrale = broj_telefona_centrale;
		this.email = email;
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



	public String getAdresa() {
		return adresa;
	}



	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}



	public long getBroj_telefona_centrale() {
		return broj_telefona_centrale;
	}



	public void setBroj_telefona_centrale(long broj_telefona_centrale) {
		this.broj_telefona_centrale = broj_telefona_centrale;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Set<Trener> getTreneri() {
		return treneri;
	}



	public void setTreneri(Set<Trener> treneri) {
		this.treneri = treneri;
	}



	public Set<Sala> getSale() {
		return sale;
	}



	public void setSale(Set<Sala> sale) {
		this.sale = sale;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "FitnessCentar [id=" + id + ", naziv=" + naziv + ", adresa=" + adresa + ", broj_telefona_centrale=" + broj_telefona_centrale+ ", email=" + email
				+ "]";
	}




	public void setAdministrator(Administrator administrator) {
		this.administrator=administrator;
		
	}

		
	}
	
