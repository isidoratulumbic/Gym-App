package wp.FitnessCentar.service;

import java.util.List;


import wp.FitnessCentar.model.Sala;

public interface SalaService {
	
	 
	 Sala create(Sala sala) throws Exception;

	 Sala save(Sala sala);

	 Sala findOne(Long id);
	 
	 List<Sala> findAll();

	 void delete(Long id);

	
	

	

}