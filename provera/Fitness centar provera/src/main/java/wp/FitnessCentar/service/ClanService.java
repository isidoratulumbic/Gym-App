package wp.FitnessCentar.service;

import java.util.List;

import wp.FitnessCentar.model.Clan;

public interface ClanService {
	 Clan findOne(Long id);
	 
	 List<Clan> findAll();
	 
	 Clan create(Clan clan) throws Exception;

	  void delete(Long id);

}
