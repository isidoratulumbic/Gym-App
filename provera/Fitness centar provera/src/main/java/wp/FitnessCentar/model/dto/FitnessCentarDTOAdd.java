package wp.FitnessCentar.model.dto;

public class FitnessCentarDTOAdd {
	
		private Long id;
		private String naziv;
		private String adresa;
		private Long broj_telefona_centrale;
		private String email;
		private String administrator;
		public FitnessCentarDTOAdd(Long id, String naziv, String adresa, Long broj_telefona_centrale, String email
				) {
			super();
			this.id = id;
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
		public Long getBroj_telefona_centrale() {
			return broj_telefona_centrale;
		}
		public void setBroj_telefona_centrale(Long broj_telefona_centrale) {
			this.broj_telefona_centrale = broj_telefona_centrale;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAdministrator() {
			return administrator;
		}
		public void setAdministrator(String administrtor) {
			this.administrator = administrator;
		}
		
		
		
}