package wp.FitnessCentar.service;

import java.util.List;

import wp.FitnessCentar.model.Termin;
import wp.FitnessCentar.model.Trening;

public interface TerminService {
	
	List<Termin> findAll();

	List<Termin> orderCena();
	
	Termin findOne(Long id);
	
	 List<Termin> findByTrening(Trening t);
	 
	 Termin save(Termin t);

}
