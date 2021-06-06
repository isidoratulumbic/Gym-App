package wp.FitnessCentar.service;

import java.util.List;


import wp.FitnessCentar.model.Trening;


public interface TreningService {
	
	 
	 List<Trening> findAll();
	 
	 Trening create(Trening trening) throws Exception;
	 
	 Trening save(Trening t);
	 
	 List<Trening> orderNaziv();
	 
	 List<Trening> orderTip();
	 
	 List<Trening> orderOpis();
	 
	/* List<Trening> orderCena();
	 
	 List<Trening> orderVreme();*/
	
}