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
	
	/*@OneToMany(mappedBy="fitness_centar",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Trener> treneri = new HashSet<>();*/
	
	@OneToMany(mappedBy = "fitness_centar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Sala> sale = new HashSet<>();

	@ManyToMany
    @JoinTable(name = "FitnessCentar_treninzi",
    joinColumns = @JoinColumn(name = "fitness_centar_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
	private Set<Treninzi> raspored = new HashSet<>();
	
	@Override
	public String toString() {
		return "FitnessCentar [id=" + id + ", naziv=" + naziv + ", adresa=" + adresa + ", broj_telefona_centrale=" + broj_telefona_centrale+ ", email=" + email
				+ "]";
	}
	
	
	

}
