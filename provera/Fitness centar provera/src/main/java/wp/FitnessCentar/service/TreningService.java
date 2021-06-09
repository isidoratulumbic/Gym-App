package wp.FitnessCentar.service;

import java.util.List;


import wp.FitnessCentar.model.Trening;
import wp.FitnessCentar.model.dto.TreninziDTO;


public interface TreningService {
	
	 
	 List<Trening> findAll();
	 
	 Trening create(Trening trening) throws Exception;
	 
	/* Trening save(Trening t);*/
	 
	 Trening findOne(Long id);
	 
	 Trening save(Trening trening);
	 
	/* List<Trening> orderCena();
	 
	 List<Trening> orderVreme();*/
	 
	 TreninziDTO getData();
	 
	 void setRating(Long id,double ocenjivanje);
	
}