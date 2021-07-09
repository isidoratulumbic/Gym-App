package wp.FitnessCentar.service;

import java.util.List;


import wp.FitnessCentar.model.FitnessCentar;

public interface FitnessCentarService {
	
	 
	 FitnessCentar create(FitnessCentar fitnessCentar) throws Exception;

	 FitnessCentar save(FitnessCentar fc);

	 FitnessCentar findOne(Long id);
	 
	 List<FitnessCentar> findAll();

	 void delete(Long id);

	void saveFitnessCentar(FitnessCentar fc);

	FitnessCentar findNaziv(String naziv);

	
	

	

}
