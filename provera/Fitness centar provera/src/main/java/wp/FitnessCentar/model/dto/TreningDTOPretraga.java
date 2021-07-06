package wp.FitnessCentar.model.dto;


import java.util.Date;

public class TreningDTOPretraga {
		private Long id;
		private String naziv;
		private String tipTreninga;
		private String opis;
		private int cena;
		private String vreme;
		public TreningDTOPretraga(Long id, String naziv, String tipTreninga, String opis, int cena, String vreme) {
			super();
			this.id = id;
			this.naziv = naziv;
			this.tipTreninga = tipTreninga;
			this.opis = opis;
			this.cena = cena;
			this.vreme = vreme;
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
		public String getTipTreninga() {
			return tipTreninga;
		}
		public void setTipTreninga(String tipTreninga) {
			this.tipTreninga = tipTreninga;
		}
		public String getOpis() {
			return opis;
		}
		public void setOpis(String opis) {
			this.opis = opis;
		}
		public int getCena() {
			return cena;
		}
		public void setCena(int cena) {
			this.cena = cena;
		}
		public String getVreme() {
			return vreme;
		}
		public void setVreme(String vreme) {
			this.vreme = vreme;
		}
		
		

}

