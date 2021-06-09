package wp.FitnessCentar.model.dto;

import java.util.List;

import wp.FitnessCentar.model.Trening;



public class TreninziDTO {
    private List<Trening> treninzi;
	
	private List<String> tipTreninga;

	public List<Trening> getTreninzi() {
		return treninzi;
	}

	public void setTreninzi(List<Trening> treninzi) {
		this.treninzi = treninzi;
	}

	public List<String> getTipTreninga() {
		return tipTreninga;
	}

	public void setTipTreninga(List<String> tipTreninga) {
		this.tipTreninga =tipTreninga;
	}
	public TreninziDTO(){}

	public TreninziDTO(List<Trening> treninzi, List<String> tipTreninga) {
		super();
		this.treninzi = treninzi;
		this.tipTreninga = tipTreninga;
	}

	
	}
