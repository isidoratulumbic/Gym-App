package wp.FitnessCentar.service;

import java.util.List;

import java.util.List;

import wp.FitnessCentar.model.Trener;

public interface TrenerService {
	 Trener findOne(Long id);
	 
	 List<Trener> findAll();
	 
	 Trener create(Trener trener) throws Exception;

	  void delete(Long id);

}

