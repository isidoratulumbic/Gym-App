package wp.FitnessCentar.model.dto;

public class TreningDTO {
	
	private Long id;
	private String naziv;
	private String opis;
	private String tip_treniniga;
	private String trajanje;
	
	public TreningDTO() {
		
	}

	public TreningDTO(Long id, String naziv, String opis, String tip_treniniga, String trajanje) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.tip_treniniga = tip_treniniga;
		this.trajanje = trajanje;
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

	public String getTip_treniniga() {
		return tip_treniniga;
	}

	public void setTip_treniniga(String tip_treniniga) {
		this.tip_treniniga = tip_treniniga;
	}

	public String getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(String trajanje) {
		this.trajanje = trajanje;
	}
	
	


}
